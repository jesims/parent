#!/usr/bin/env bash
cd "$(realpath "$(dirname "$0")")" &&
	source bindle/project.sh
if [ $? -ne 0 ]; then
	exit 1
fi

export LEIN_DEV_PROFILE='+parent/dev'

## lint:
lint() {
	-lint
}

## deps:
deps() {
	-deps "$@"
}

## outdated:
outdated() {
	-outdated
}

## install:
## install project.clj to local maven repository
install() {
	lein install
	abort-on-error
	#TODO install package-dry.json locally
}

## deploy:
## deploy project.clj to Clojars.org
deploy() {
	lein deploy clojars
}

## publish:
## publish package-dry.json to NPM
publish() {
	if is-ci; then
		require-var NPM_TOKEN
		echo "//registry.npmjs.org/:_authToken=$NPM_TOKEN" >"$HOME"/.npmrc
		abort-on-error 'creating .npmrc'
	fi
	dry publish --access public
}

script-invoke "$@"
