(ns reframe-testing.views
  (:require [reagent.core :as r]))

(defn home-page []
  [:div
   [:h1 "Home"]
   [:p "Welcome to our home page."]])

(defn about-page []
  [:div
   [:h1 "About"]
   [:p "This site is built with Re-frame and Reitit."]])

(defn contact-page []
  [:div
   [:h1 "Contact Us"]
   [:p "You can reach us at contact@example.com."]])