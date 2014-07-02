(ns helloworld.core
  "Example based on HelloWorld.elm:
  http://elm-lang.org/edit/examples/Elements/HelloWorld.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn plain-text
  [cursor owner]
  (reify
    om/IRender
    (render [_]
            (dom/p nil "Hello, World!"))))

(om/root plain-text {} {:target (.getElementById js/document "app")})
