(defproject elm-examples "0.0.1"
  :description "Examples from the Elm language ported to ClojureScript/Om"
  :url "https://github.com/michael-okeefe/elm-examples"
  :license {:name "Eclipse"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [om "0.6.4"]]
  :plugins [[lein-cljsbuild "1.0.3"]]
  :cljsbuild {:builds [{:id "textfield"
                        :source-paths ["examples/textfield/src"]
                        :compiler {:output-to "examples/textfield/js/textfield.js"
                                   :output-dir "examples/textfield/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "helloworld"
                        :source-paths ["examples/helloworld/src"]
                        :compiler {:output-to "examples/helloworld/js/helloworld.js"
                                   :output-dir "examples/helloworld/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "markdown"
                        :source-paths ["examples/markdown/src"]
                        :compiler {:output-to "examples/markdown/js/markdown.js"
                                   :output-dir "examples/markdown/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "image"
                        :source-paths ["examples/image/src"]
                        :compiler {:output-to "examples/image/js/image.js"
                                   :output-dir "examples/image/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "fittedimage"
                        :source-paths ["examples/fittedimage/src"]
                        :compiler {:output-to "examples/fittedimage/js/fittedimage.js"
                                   :output-dir "examples/fittedimage/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "croppedimage"
                        :source-paths ["examples/croppedimage/src"]
                        :compiler {:output-to "examples/croppedimage/js/croppedimage.js"
                                   :output-dir "examples/croppedimage/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "size"
                        :source-paths ["examples/size/src"]
                        :compiler {:output-to "examples/size/js/size.js"
                                   :output-dir "examples/size/js"
                                   :source-map true
                                   :optimizations :none}}

                       ]})
