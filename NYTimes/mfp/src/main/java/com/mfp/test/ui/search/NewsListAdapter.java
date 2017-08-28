package com.mfp.test.ui.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mfp.test.R;
import com.mfp.test.data.network.model.Doc;
import com.mfp.test.data.network.model.Multimedia;
import com.mfp.test.ui.base.BaseViewHolder;
import com.mfp.test.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_ROW = 1;
    public static final int VIEW_TYPE_ROW_MM = 2;

    private Callback mCallback;
    private List<Doc> mNewsArticleList;

    public NewsListAdapter(List<Doc> blogResponseList) {
        mNewsArticleList = blogResponseList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_ROW_MM:
                return new ViewHolderMM(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mm, parent, false));
            case VIEW_TYPE_ROW:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.error_layout, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mNewsArticleList == null || mNewsArticleList.size() == 0) {
            return VIEW_TYPE_EMPTY;
        } else if (mNewsArticleList.get(position).getMultimedia() == null || mNewsArticleList.get(position).getMultimedia().isEmpty()) {
            return VIEW_TYPE_ROW;
        } else {
            return VIEW_TYPE_ROW_MM;
        }
    }

    @Override
    public int getItemCount() {
        if (mNewsArticleList != null && mNewsArticleList.size() > 0) {
            return mNewsArticleList.size();
        } else {
            return 1;
        }
    }

    public void clear() {
        mNewsArticleList.clear();
    }

    public void addItems(List<Doc> newsList) {
        mNewsArticleList.addAll(newsList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onNewsEmptyViewRetryClick();
        void onNewsArticleClick(Doc doc);
    }

    public class ViewHolderMM extends BaseViewHolder {

        @BindView(R.id.photo)
        ImageView photoView;

        @BindView(R.id.text_heading)
        TextView headingTextView;

        @BindView(R.id.text_snippet)
        TextView snippetTextView;

        public ViewHolderMM(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            photoView.setImageDrawable(null);
            headingTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Doc news = mNewsArticleList.get(position);
            String coverImageUrl = getCoverImgUrl(news);
            if (coverImageUrl != null) {
                Glide.with(itemView.getContext())
                        .load(coverImageUrl)
                        .asBitmap()
                        .centerCrop()
                        .into(photoView);
            }

            if (news.getHeadline().getMain() != null) {
                headingTextView.setText(news.getHeadline().getMain());
            }

            if (news.getSnippet() != null) {
                snippetTextView.setText(news.getSnippet());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (news.getWebUrl() != null) {
                        if (mCallback != null) {
                            mCallback.onNewsArticleClick(news);
                        }
                    }
                }
            });
        }
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.text_snippet)
        TextView snippetTextView;

        @BindView(R.id.text_heading)
        TextView headingTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            snippetTextView.setText("");
            headingTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Doc news = mNewsArticleList.get(position);

            if (news.getHeadline().getMain() != null) {
                headingTextView.setText(news.getHeadline().getMain());
            }

            if (news.getSnippet() != null) {
                snippetTextView.setText(news.getSnippet());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (news.getWebUrl() != null) {
                        if (mCallback != null) {
                            mCallback.onNewsArticleClick(news);
                        }
                    }
                }
            });
        }
    }

    String getCoverImgUrl(Doc doc) {
        List<Multimedia> multimedia = doc.getMultimedia();

        for(Multimedia m : multimedia) {
            if (m.getType().equals(AppConstants.MEDIA_TYPE_IMAGE) && m.getSubtype().
                    equals(AppConstants.MEDIA_SUB_TYPE_XLARGE)) {
                return "http://www.nytimes.com/" + m.getUrl();

            }
        }
        return null;
    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.error_layout)
        LinearLayout errorLayout;

        @BindView(R.id.error_btn_retry)
        Button retryButton;

        @BindView(R.id.error_txt_cause)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            errorLayout.setVisibility(View.VISIBLE);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.error_btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onNewsEmptyViewRetryClick();
        }
    }
}
