# Examples from Elm ported to ClojureScript/Om

[Om](https://github.com/swannodette/om) presents a nice ClojureScript interface
to Facebook's React. In an effort to learn how to more effectively use Om, I
decided to begin porting [examples](http://elm-lang.org/Examples.elm) from the
[Elm programming language](http://elm-lang.org/) -- Elm is a functional reactive
language for interactive applications and already sports some very impressive
demos.

Note that the objective is not to use the same techniques as Elm, but instead
to show how the same content and behavior associated with each Elm example can
be rendered to the screen. This is a necessary deviation as Elm works quite
differently than Om and Om is new enough that we do not yet have enough
available libraries for drop-in replacement (for example, there currently are
no Markdown-to-React-DOM-element libraries). Therefore, each example
demonstrates how to use ClojureScript and Om to "get more or less the same
content and behavior on-screen as shown in each Elm example program."

## Usage

To run each demo, download this project to your desktop and, from within the top
directory, type:

    > lein cljsbuild once <example-name>

Then, open your web-browser (any should be fine but Chrome has some nice
development features for source-maps) to the index.html page inside the
corresponding example directory.

Copyright © 2014 Michael Patrick O'Keefe

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
