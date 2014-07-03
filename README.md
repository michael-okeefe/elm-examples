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
content and behavior" on-screen as shown in each Elm example program.

## Usage

To run each demo, download this project to your desktop and, from within the top
directory, type:

    > lein cljsbuild once <example-name>

Then, open your web-browser (any should be fine but Chrome has some nice
development features for source-maps) to the index.html page inside the
corresponding example directory.

To add a new example:

    > lein repl
    ...
    user=> (require '[example.mknew :refer [new-example]])
    user=> (let [example-name "newexample"
                 title "My New Example"]
             (new-example example-name title))

This will create a new directory user `examples/<newexample>` pre-populated with
some template files for creating new examples. Edit the
`examples/<newexample>/src/core.cljs` file to begin creating your new example.
You may on occasion need to edit the index.html as well (to add new structure or
for adding static CSS).

# Photo Credits

Image "rocks.jpg" is by Diego Delso. Photo obtained from Wikimedia commons
[here](http://commons.wikimedia.org/wiki/Main_page#mediaviewer/File:Prismas_Bas%C3%A1lticos,_Huasca_de_Ocampo,_Hidalgo,_M%C3%A9xico,_2013-10-10,_DD_10.JPG).

Image "waves.jpg" is by [Thomas Shahan](https://www.flickr.com/people/49580580@N02) and available via Wikimedia commons [here](http://commons.wikimedia.org/wiki/Category:Oceans#mediaviewer/File:Kiwanda_Waves_Crashing_(8401374834).jpg).

------------------------------------------------------------

Copyright © 2014 Michael Patrick O'Keefe

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
