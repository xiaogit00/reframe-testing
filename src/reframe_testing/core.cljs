(ns reframe-testing.core
  (:require
   [reagent.dom :as dom]
   [re-frame.core :as rf]
   [reframe-testing.routes :as routes]
   [reframe-testing.events]
   [reframe-testing.views :as views]
   [reframe-testing.subs]))

(defn page []
  (let [current-page @(rf/subscribe [:current-page])]
    (when-let [view (get-in current-page [:data :view])]
      [view])))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (dom/render [page] (.getElementById js/document "app")))

(defn ^:dev/after-load start []
  (mount-root))

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (routes/init-routes!)
  (mount-root))