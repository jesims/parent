(def slf4j-version "1.7.26")

(defproject io.jesi/parent "2.1.0"
  :description "Clojure and NPM parent package definitions"
  :url "https://github.com/jesims/parent#readme"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :min-lein-version "2.8.1"
  :managed-dependencies [[org.clojure/clojure "1.10.1"]
                         [thheller/shadow-cljs "2.8.74"]
                         [io.jesi/backpack "3.7.0"]
                         [com.rpl/specter "1.1.3"]
                         [org.clojure/core.async "0.5.527"]
                         ;DB
                         [org.clojure/java.jdbc "0.7.10"]
                         [org.postgresql/postgresql "42.2.8"]
                         [clj-postgresql "0.7.0"]
                         [nilenso/honeysql-postgres "0.2.6"]
                         ;Logging
                         [ch.qos.logback/logback-classic "1.2.3"]
                         [org.slf4j/jcl-over-slf4j ~slf4j-version]
                         [org.slf4j/jul-to-slf4j ~slf4j-version]
                         [org.slf4j/log4j-over-slf4j ~slf4j-version]
                         [org.slf4j/slf4j-api ~slf4j-version]
                         [org.clojure/tools.logging "0.4.1"]]
  :dependencies [[org.clojure/clojure]]
  :exclusions [org.clojure/clojure org.clojure/clojurescript]
  :profiles {:parent/dev {:plugins      [[com.jakemccrary/lein-test-refresh "0.24.1"]
                                         [lein-ancient "0.6.15"]
                                         [lein-auto "0.1.3"]
                                         [lein-nsorg "0.3.0"]
                                         [lein-pprint "1.2.0"]
                                         [lein-set-version "0.4.1"]]
                          :dependencies [[circleci/circleci.test "0.4.2"]]}}
  :global-vars {*warn-on-reflection* true}
  :test-refresh {:focus-flag   :focus
                 :quiet        true
                 :with-repl    true
                 :changes-only true}
  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :username      :env/clojars_username
                                    :password      :env/clojars_password
                                    :sign-releases false}]]
  :aliases {"lint"   ["nsorg" "--replace"]
            "test"   ["run" "-m" "circleci.test/dir" :project/test-paths]
            "tests"  ["run" "-m" "circleci.test"]
            "retest" ["run" "-m" "circleci.test.retest"]})
