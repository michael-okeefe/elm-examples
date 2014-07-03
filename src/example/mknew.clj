(ns example.mknew
  "Create a new example folder"
  (:require [clojure.java.io :as io]))

(defn index-content
  [title name]
  (apply format "<!doctype html>
<html>
  <head>
    <meta charset=\"utf-8\">
    <title>%s Example</title>
  </head>
  <body>
    <!-- Attention LightTable users:
         paste the result of \"Add Connection > Browser (External)\" below this
         comment, otherwise ignore.
    -->
    <div id=\"app\"></div>
    <script src=\"http://fb.me/react-0.9.0.js\"></script>
    <script src=\"js/goog/base.js\" type=\"text/javascript\"></script>
    <script src=\"js/%s.js\" type=\"text/javascript\"></script>
    <script type=\"text/javascript\">goog.require(\"%s.core\");</script>
  </body>
</html>" [title name name]))

(defn core-ns-content
  [name]
  (format "(ns %s.core
  \"Doc String\"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/p nil \"Hello World!\"))))

(om/root <fn> {} {:target (.getElementById js/document \"app\")})" name))

(defn mkdir
  [name]
  (let [f (io/file (str "examples/" name "/src"))]
    (.mkdirs f)))

(defn copy-gitignore
  [name]
  (let [gitignore-content (slurp "examples/helloworld/.gitignore")
        f (io/file (str "examples/" name "/.gitignore"))]
    (spit f gitignore-content)))

(defn new-example
  [name title]
  (let [index-file (io/file (str "examples/" name "/index.html"))
        cljs-file (io/file (str "examples/" name "/src/core.cljs"))]
    (mkdir name)
    (copy-gitignore name)
    (spit index-file (index-content title name))
    (spit cljs-file (core-ns-content name))))
