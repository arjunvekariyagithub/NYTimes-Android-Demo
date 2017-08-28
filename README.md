# NYTimes-Android-Demo
Android challenge for MFP

## Libraries
  - [Retrofit](https://square.github.io/retrofit/) as HTTP client
  - [Glide](https://github.com/bumptech/glide) for image downloaiding and display
  - [RxJava](https://github.com/ReactiveX/RxJava) to efficiently handle async network calls and employ reactive pattern
  - [Dagger](https://google.github.io/dagger/) for dependency injection
 
## Architecture
  - [MVP](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) (Mode-View-Presenter)
  - There are many architectures available for application design: MVC, MVP, MVVC etc. I have used MVP as Presenter in MVP is 
    just an interface and not at all tied to the View. Due to this, MVP is quite suitable for unit and instrumentation testing 
    as well as it is more flexible compare to MVC.

### Why I choose Glide amonst many available options?
I have experimented with other Image loading libraries: [Picasso](http://square.github.io/picasso/), [Volly](https://github.com/google/volley) and [Fresco](https://github.com/facebook/fresco), but [Glide](https://github.com/bumptech/glide) seems to be performing best amongst all due to it's well optimized Cache mechanism.

### Pagination
  - I have used [EndlessRecyclerViewScrollListener](https://gist.github.com/nesquena/d09dc68ff07e845cc622) for pagination as
    it is robust and very simple to use
