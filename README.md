# Examples from Elm ported to ClojureScript/Om

[Om](https://github.com/swannodette/om) presents a nice ClojureScript interface
to Facebook's React. In an effort to learn how to more effectively use Om, I
decided to begin porting [examples](http://elm-lang.org/Examples.elm) from the
[Elm programming language](http://elm-lang.org/) -- Elm is a functional reactive
language for interactive applications and already sports some very impressive
demos.

## Usage

To run each demo, download this project to your desktop and, from within the top
directory, type:

    > lein cljsbuild once <example-name>

Then, open your web-browser (any should be fine but Chrome has some nice
development features for source-maps) to the index.html page inside the example
directory.

Copyright © 2014 Michael Patrick O'Keefe

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
