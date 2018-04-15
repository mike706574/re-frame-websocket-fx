# re-frame-websocket-fx

[![Clojars Project](https://img.shields.io/clojars/v/fun.mike/re-frame-websocket-fx.svg)](https://clojars.org/fun.mike/re-frame-websocket-fx)

A re-frame websocket effect handler.

## Example

```clojure
(require [fun.mike.re-frame.websocket-fx])

(reg-event-fx
 :connect-websocket
 (fn [{_ _]
   {:websocket {:method :get
                :uri ws-url
                :on-message [:message-received]
                :on-success [:websocket-success]
                :on-failure [:websocket-failure]}}))
```

## Build

[![CircleCI](https://circleci.com/gh/mike706574/re-frame-websocket-fx.svg?style=svg)](https://circleci.com/gh/mike706574/re-frame-websocket-fx)

## Copyright and License

The use and distribution terms for this software are covered by the
[Eclipse Public License 1.0] which can be found in the file
epl-v10.html at the root of this distribution. By using this softwaer
in any fashion, you are agreeing to be bound by the terms of this
license. You must not remove this notice, or any other, from this
software.

[Eclipse Public License 1.0]: http://opensource.org/licenses/eclipse-1.0.php
