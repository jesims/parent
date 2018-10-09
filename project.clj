(defproject io.jesi/parent "0.0.1"
  :description "Clojure and NPM parent package definitions"
  :url "https://github.com/jesims/parent#readme"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :min-lein-version "2.8.1"
  :managed-dependencies [[org.clojure/clojure "1.9.0"]
                         [org.clojure/clojurescript "1.10.339"]
                         [org.clojure/core.async "0.4.474"]
                         [thheller/shadow-cljs "2.6.10"]
                         [com.rpl/specter "1.1.1"]
                         [io.jesi/backpack "0.0.17"]]
  :dependencies [[org.clojure/clojure]]
  :exclusions [org.clojure/clojure
               org.clojure/clojurescript]
  :profiles {:dev {:plugins      [[com.jakemccrary/lein-test-refresh "0.22.0"]
                                  [lein-ancient "0.6.14"]
                                  [lein-auto "0.1.3"]
                                  [lein-set-version "0.4.1"]
                                  [venantius/ultra "0.5.2" :exclusions [org.clojure/clojure]]]
                   :dependencies [[circleci/circleci.test "0.4.1"]
                                  [pjstadig/humane-test-output "0.8.3"]]
                   :injections   [(require 'pjstadig.humane-test-output)
                                  (pjstadig.humane-test-output/activate!)]}}
  :global-vars {*warn-on-reflection* true}
  :test-refresh {:quiet        true
                 :with-repl    true
                 :changes-only true}
  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :username      :env/clojars_username
                                    :password      :env/clojars_password
                                    :sign-releases false}]])
