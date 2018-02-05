(ns fun.mike.re-frame.websocket-fx
  (:require [re-frame.core :as rf]))

(defn websocket-effect
  [{:as request
    :keys [uri on-message on-error on-success on-failure existing-websocket]}]
  (if existing-websocket
    (rf/dispatch (conj on-success existing-websocket))
    (let [websocket (js/WebSocket. uri)]
      (set! (.-onmessage websocket) #(rf/dispatch (conj on-message %)))
      (set! (.-onerror websocket) #(rf/dispatch (conj on-failure %)))
      (set! (.-onopen websocket) (fn on-open []
                                   (set! (.-onerror websocket) #(rf/dispatch (conj on-error %)))
                                   (rf/dispatch (conj on-success websocket)))))))


(rf/reg-fx :websocket websocket-effect)
