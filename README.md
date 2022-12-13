# template

A template clj repo with some plugins that I like to use. backed by `deps.edn`

Comes with:
- `deps.edn`
- `compojure` + `ring` for a basic API Server with a healthcheck endpoint
- [`component`](https://github.com/stuartsierra/component)


I use [`vim-iced`](https://liquidz.github.io/vim-iced/) for all REPL management. Once you installed you can run something like `iced repl -A:dev`. Within the repl, you can call the various `component` lifecycle methods like `(init)` and `(start)`.

If you copy this template, you probably want to `sed` the word `template` with your project name. For example, I usually do something like this:

```sh
git clone  ...
sed -e 's/template/myservice/g' ./**/*.clj
```
