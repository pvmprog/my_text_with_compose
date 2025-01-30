package com.pvmprog.mytextwithcompose.ui.shader

import org.intellij.lang.annotations.Language

@Language("AGSL")
const val SHADER_GRADIENT = """
// Параметры шейдера    
   uniform float2 iResolution;      // Viewport resolution (pixels)
   uniform float  iTime;            // Shader playback time (s)
// Тело шейдера 
   half4 main(float2 fragCoord) {
// Нормализованные координаты пикселей (from 0 to 1)
      float2 scaled = fragCoord/iResolution.xy;
      float2 col = abs(1.0-mod(scaled+0.5*cos(iTime+vec2(0,2)),2.0));      
      return half4(col, 0.2, 1);
      
}      
"""