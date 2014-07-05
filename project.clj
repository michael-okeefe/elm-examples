(require 'leiningen.core.eval)

(defn example
  "Return a cljsbuild build setup"
  [example-name]
  {:id example-name
   :source-paths [(str "examples/" example-name "/src")]
   :compiler {:output-to (str "examples/" example-name
                              "/js/" example-name ".js")
              :output-dir (str "examples/" example-name "/js")
              :source-map true
              :optimizations :none}})

(defn examples
   "Return a vector of all the build setups for each example"
   []
   (mapv example
         ["textfield" "helloworld" "markdown"
          "image" "fittedimage" "croppedimage"
          "size" "opacity" "text" "typeface"
          "flowdown1a" "layers" "position"
          "spacer" "lines" "shapes" "toform"
          "transforms"]))

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
  :cljsbuild {:builds ^:replace ~(examples)})
