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
                       {:id "opacity"
                        :source-paths ["examples/opacity/src"]
                        :compiler {:output-to "examples/opacity/js/opacity.js"
                                   :output-dir "examples/opacity/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "text"
                        :source-paths ["examples/text/src"]
                        :compiler {:output-to "examples/text/js/text.js"
                                   :output-dir "examples/text/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "typeface"
                        :source-paths ["examples/typeface/src"]
                        :compiler {:output-to "examples/typeface/js/typeface.js"
                                   :output-dir "examples/typeface/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "flowdown1a"
                        :source-paths ["examples/flowdown1a/src"]
                        :compiler {:output-to "examples/flowdown1a/js/flowdown1a.js"
                                   :output-dir "examples/flowdown1a/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "layers"
                        :source-paths ["examples/layers/src"]
                        :compiler {:output-to "examples/layers/js/layers.js"
                                   :output-dir "examples/layers/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "position"
                        :source-paths ["examples/position/src"]
                        :compiler {:output-to "examples/position/js/position.js"
                                   :output-dir "examples/position/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "spacer"
                        :source-paths ["examples/spacer/src"]
                        :compiler {:output-to "examples/spacer/js/spacer.js"
                                   :output-dir "examples/spacer/js"
                                   :source-map true
                                   :optimizations :none}}
                       {:id "lines"
                        :source-paths ["examples/lines/src"]
                        :compiler {:output-to "examples/lines/js/lines.js"
                                   :output-dir "examples/lines/js"
                                   :source-map true
                                   :optimizations :none}}

                       ]})
