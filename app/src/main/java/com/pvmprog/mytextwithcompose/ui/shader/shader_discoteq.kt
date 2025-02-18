package com.pvmprog.mytextwithcompose.ui.shader

import org.intellij.lang.annotations.Language

//https://www.shadertoy.com/view/DtXfDr
//шейдер from OpenGL into AGSL
@Language("AGSL")
const val SHADER_DISCOTEQ = """
// Параметры шейдера    
                uniform float2 iResolution;      // Viewport resolution (pixels)
                uniform float  iTime;            // Shader playback time (s)
// Тело шейдера    

vec4 Line(vec2 uv, float speed, float height, vec3 col) {
    uv.y += smoothstep(1., 0., abs(uv.x)) * sin(iTime * speed + uv.x * height) * .2;
    return vec4(smoothstep(.06 * smoothstep(.2, .9, abs(uv.x)), 0., abs(uv.y) - .004) * col, 1.0) * smoothstep(1., .3, abs(uv.x));
}

vec4 main( in vec2 I) {
    vec2 uv = (I - .5 * iResolution.xy) / iResolution.y;
    vec4 O = vec4 (0.);
    for (float i = 0.; i <= 5.; i += 1.) {
        float t = i / 5.;
        O += Line(uv, 1. + t, 4. + t, vec3(.2 + t * .7, .2 + t * .4, 0.3));
    }
    return O; 
}
            """
