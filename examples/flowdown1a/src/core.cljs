(ns flowdown1a.core
  "Simple 'flow down' layout:
  http://elm-lang.org/edit/examples/Elements/FlowDown1a.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn element
  [txt]
  (dom/div #js {:style #js {:text-align "left"}}
           txt))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil
               (element "Even without using the \"flow\" function,")
               (element "we can still stack elements")
               (element "on top of other elements")))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
