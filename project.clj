(defproject io.jesi/parent "0.0.18"
  :description "Clojure and NPM parent package definitions"
  :url "https://github.com/jesims/parent#readme"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :min-lein-version "2.8.1"
  :managed-dependencies [[org.clojure/clojure "1.10.0"]
                         [org.clojure/clojurescript "1.10.520"]
                         [org.clojure/core.async "0.4.490"]
                         [org.clojure/java.jdbc "0.7.9"]
                         [thheller/shadow-cljs "2.8.36"]
                         [com.rpl/specter "1.1.2"]
                         [io.jesi/backpack "1.0.0"]]
  :dependencies [[org.clojure/clojure]]
  :exclusions [org.clojure/clojure org.clojure/clojurescript]
  :profiles {:dev {:plugins      [[com.jakemccrary/lein-test-refresh "0.24.1"]
                                  [lein-ancient "0.6.15"]
                                  [lein-auto "0.1.3"]
                                  [lein-set-version "0.4.1"]
                                  [venantius/ultra "0.6.0"]]
                   :dependencies [[circleci/circleci.test "0.4.2"]
                                  [pjstadig/humane-test-output "0.9.0"]]
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
