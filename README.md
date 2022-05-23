# cljs-reagent-reframe-unocss-boilerplate

An opinionated boilerplate for Reagent app.

- [shadow-cljs](https://github.com/thheller/shadow-cljs)
- [reagent](https://github.com/reagent-project/reagent) (react on dev mode & preact on production)
- [re-frame](https://github.com/day8/re-frame)
- [unocss](https://github.com/unocss/unocss)

### Installation

```bash
npm install
```

### Development

```bash
npm run dev
# served to `http://localhost:5000`.

# or with the netlify-cli
ntl dev
```

### Build and serve on production mode

On production mode React is replaced by Preact

```bash
npm run build
npm run serve

# served to `http://localhost:5000`.
```
