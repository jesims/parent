(defproject io.jesi/parent "3.0.1"
  :description "Clojure and NPM parent package definitions"
  :url "https://github.com/jesims/parent#readme"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :min-lein-version "2.9.1"
  :managed-dependencies [[org.clojure/clojure "1.10.1"]
                         [thheller/shadow-cljs "2.8.77"]
                         [org.clojure/clojurescript "1.10.597"] ;Match version used in shadow-cljs
                         [io.jesi/backpack "5.0.0"]
                         [io.jesi/customs "1.0.0"]
                         [com.rpl/specter "1.1.3"]
                         [org.clojure/core.async "0.6.532"]
                         ;DB
                         [org.clojure/java.jdbc "0.7.11"]
                         [org.postgresql/postgresql "42.2.9"]
                         [clj-postgresql "0.7.0"]
                         [nilenso/honeysql-postgres "0.2.6"]]
  :dependencies [[org.clojure/clojure]]
  :exclusions [org.clojure/clojure org.clojure/clojurescript]
  :profiles {:parent/dev {:plugins      [[lein-ancient "0.6.15"]
                                         [lein-auto "0.1.3"]
                                         [lein-codox "0.10.7"]
                                         [lein-nsorg "0.3.0"]
                                         [lein-pprint "1.2.0"]
                                         [lein-set-version "0.4.1"]]
                          :dependencies [[lambdaisland/kaocha "0.0-565"]
                                         [lambdaisland/kaocha-cljs "0.0-68"]]}
             :dev        [:parent/dev]
             :test       [:dev]}
  :global-vars {*warn-on-reflection* true}
  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :username      :env/clojars_username
                                    :password      :env/clojars_password
                                    :sign-releases false}]]
  :codox {:output-path "docs"}
  :aliases {"lint"         ["nsorg" "--replace"]
            "test"         ["run" "-m" "kaocha.runner"]
            "tests"        ["test" "--focus"]
            "test-refresh" ["test" "--watch"]
            "docs"         ["codox"]})
