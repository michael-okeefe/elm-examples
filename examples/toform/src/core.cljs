(ns toform.core
  "Example of using 'forms' (not the kind you are thinking of) from Elm:
  http://elm-lang.org/edit/examples/Elements/ToForm.elm"
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(def transform-matrix
  (str "matrix(0.9396926164627075, -0.3420201539993286, "
       " 0.3420201539993286, 0.9396926164627075, 9.5, 91);"))

(defn <fn>
  [cursor owner]
  (reify
    om/IRender
    (render [_]
      (dom/div #js {:style #js {:width "200px" :height "200px"}}
               (dom/div #js {:style #js {:text-align "left"
                                         :-webkit-transform transform-matrix}}
                        "Any element can go here!")))))

(om/root <fn> {} {:target (.getElementById js/document "app")})
