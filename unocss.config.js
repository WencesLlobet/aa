import presetWind from "@unocss/preset-wind";
import presetWebFonts from "@unocss/preset-web-fonts";
import { defineConfig } from "unocss";

export default defineConfig({
  presets: [
    presetWebFonts({
      provider: "google",
      fonts: {
        sans: "Roboto",
      },
    }),
    presetWind(),
  ],
  shortcuts: [
    { box: "max-w-7xl mx-auto bg-gray-100 rounded-md shadow-sm p-4" },
  ],
});
