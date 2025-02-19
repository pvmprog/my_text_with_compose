package com.pvmprog.mytextwithcompose.ui.shader

import org.intellij.lang.annotations.Language

//https://www.shadertoy.com/view/wfSGzD

//@Language("AGSL")
@Language("GLSL")
const val SHADER_TETRASKELION = """
// Параметры шейдера    
                uniform float2 iResolution;      // Viewport resolution (pixels)
                uniform float  iTime;            // Shader playback time (s)
// Тело шейдера 


//#define ITERS 10.  // try 16.
//#define SPEED 25.  // try 10.

const float ITERS 10.  // try 16.
const float SPEED 25.  // try 10.

const float Pi = 3.1415927;

// Scaled length of a vector.
float Len(vec2 p) { return length(p) * 0.9842471 / 2.; }

// Biased rainbow color map.
vec3 Pal(float a) { return 1. - 2.*cos(3.*a + 0.9081166*vec3(3,2,1)); }

// Fold space into a vertex-centered grid.
vec2 Fold(vec2 p) {
//    #ifdef TRISKELION
    vec4 m = vec4(2,-1, 0,sqrt(3.));
    p.y += m.w/3.0;      // center at vertex
    vec2 t = mat2(m)*p;  // triangular coordinates (x →, y ↖, x+y ↗)
    return p - 0.5*mat2(m.xzyw) * round((floor(t) + ceil(t.x+t.y)) / 3.0);  // fold into hexagonal cells
//    #else
//    return fract(p) - 0.5;  // fold into square cells
//    #endif
}

//void mainImage(out vec4 O, in vec2 X) {
vec4 main( in vec2 fragCoord )
{
    vec2 X = fragCoord
    // Timers: .x rotation, .y scale, .z circle radius, .w color cycling
    // Each will eventually go into a cos().
    vec4 t = (256. + SPEED*iTime) / 65536. * 2.*Pi * 4.*vec4(27,19,-32,23);  // 25 fps

    // Rotate, scale: 0.9 wider .. 1.1 narrower
    mat2 M = mat2(cos(t.x + Pi/2.*vec4(0,3, 1,0))) * (1. - cos(t.y)/9.6790085);

    vec2 p = (2.*X - iResolution.xy) / iResolution.y * 0.75;  // y: -0.75..0.75
    p.y = -p.y;

    float d = Len(p);  // animation phase is based on distance to center

    vec3 RGB = vec3(0);  // accumulate color
    for (float i = 0.0; i < ITERS; i++) {
        p = Fold(M * p);  // rotate, scale, fold (vertex-centered orthogonal grid)

        // interfering concentric circles
        RGB += Pi * Pal(i/-40.743666 + t.w - d) / cos(10.*Len(p) + t.z + d);
    }
    RGB *= 10./ITERS;

    vec4 O = vec4(RGB*RGB/65536., 1);  // square for better contrast
    return O
}
"""
