(ns textfield.core
  "Example based on TextField.elm:
  http://elm-lang.org/edit/examples/Reactive/TextField.elm"
  (:require [clojure.string :as string]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(defn on-text-update
  [event cursor]
  (let [text-value (-> event .-target .-value)]
    (om/update! cursor :text text-value)))

(defn reverse-text
  [cursor owner]
  (reify
    om/IRender
    (render [_]
            (dom/div nil
                     (dom/input #js {:type "text"
                                     :value (:text cursor)
                                     :placeholder "Type here!"
                                     :onChange #(on-text-update % cursor)})
                     (dom/p nil (string/reverse (:text cursor)))))))

(om/root reverse-text
         {:text ""}
         {:target (.getElementById js/document "app")})
