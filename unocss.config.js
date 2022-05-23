import presetUno from '@unocss/preset-uno'
import presetWebFonts from '@unocss/preset-web-fonts'
import { defineConfig } from 'unocss'

export default defineConfig({
  presets: [
    presetUno(),
    presetWebFonts({
      provider: 'google',
      fonts: {
        sans: 'Roboto',
      },
    }),
  ],
  shortcuts: [
    { box: 'max-w-7xl mx-auto bg-gray-100 rounded-md shadow-sm p-4' },
  ],
})