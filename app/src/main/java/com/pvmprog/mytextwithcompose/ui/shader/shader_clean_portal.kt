package com.pvmprog.mytextwithcompose.ui.shader

import org.intellij.lang.annotations.Language

/*
Shader Inputs

uniform vec3      iResolution;           // viewport resolution (in pixels)
uniform float     iTime;                 // shader playback time (in seconds)
uniform float     iTimeDelta;            // render time (in seconds)
uniform float     iFrameRate;            // shader frame rate
uniform int       iFrame;                // shader playback frame
uniform float     iChannelTime[4];       // channel playback time (in seconds)
uniform vec3      iChannelResolution[4]; // channel resolution (in pixels)
uniform vec4      iMouse;                // mouse pixel coords. xy: current (if MLB down), zw: click
uniform samplerXX iChannel0..3;          // input channel. XX = 2D/Cube
uniform vec4      iDate;                 // (year, month, day, time in seconds)
uniform float     iSampleRate;           // sound sample rate (i.e., 44100)
@Language("GLSL")

 */

//https://www.shadertoy.com/view/tfBGRz


//шейдер на OpenGL

@Language("AGSL")
const val SHADER_CLEAN_PORTAL = """
// Параметры шейдера    
                uniform float2 iResolution;      // Viewport resolution (pixels)
                uniform float  iTime;            // Shader playback time (s)
// Тело шейдера    

mat2 R(float a) { return mat2(cos(a), sin(a), -sin(a), cos(a)); }

float bevel(vec2 x, float a)
{
    //return x *= R(-3. / 5. * a - .2 * iTime), x *= R((floor(atan(x.y, x.x) / radians(72.)) + .5) * radians(72.)), x.x - .1;
    return x = abs(x) - vec2(0, .1), length(x - min(x, 0.)) - .01;
    //return length(x) - .1;
}

bool sphere = false;
float f, rs; float map(vec3 p)
{
    rs = bevel(vec2(length(p.yz - vec2(2.5, 0)) - 1., p.x), atan(p.z, p.y - 2.5));

    p.xz -= round(p.xz / 2.) * 2.;
    p.x = abs(p.x);
    p.z = abs(p.z);
    if (p.x < p.z)
        p.xz = p.zx;

    float r1 = 1. - length(p.xy - 1.);
    float r2 = p.y;
    float r3 = length(p.xy - vec2(0, 1));
    float ra = p.y > 1. ? (p.x * p.x + 1. < 2. * p.y ? r3 : r2) : (1. < p.x ? r2 : r1); // Faulty Line: https://www.shadertoy.com/view/wcl3Wl
    float rb = length(p - vec3(0, .3, 0)) - .5;

    return f = min(min(rs, p.y - .05), sphere ? rb : ra);
}

//void mainImage(out vec4 fragColor, vec2 fragCoord)
vec4 main( in vec2 fragCoord ) 
{
    float t = iTime / 3. + 5.;

    f = .8 + .5 * tanh(cos(t + radians(60.)) * 1.);
    vec3 ro = vec3(0, 3. - .5 * f, 2.5) + 2. * vec3(-sin(t), 0, cos(t));
    vec3 rd = normalize(vec3(2. * fragCoord, 0) - iResolution.xyy);
    rd.yz *= R(mix(.5, -.2, f));
    rd.xz *= R(mix(radians(-120.), atan(ro.x, -(-2.8 - ro.z)), f));
    
    vec3 p;
    float r = 0.;
    for (int i=0 ;
        p = ro + r * rd,
        // ray : ahead of portal?     crosses portal surface?                                     crossing : side of plane + phase,  else : phase
        sphere = ro.x / rd.x <= 0. && rd.x != 0. && length((ro - rd * ro.x / rd.x).yz - vec2(2.5, 0)) < 1. ? p.x < 0. == sin(t / 2.) < 0. : cos(t / 2.) < 0.,
        map(p) > 1e-4 && i<100 ; i++)
        r += f;

    vec3 sun = normalize(sphere ? vec3(-3, 2, -1) : vec3(3, 2, -1));
    vec3 C = vec3(dot(sun, rd) > .9);

    if (f < .1)
    {
        // finite-difference estimate of dot(light, normal)
        C = .5 + .5 * vec3(map(p + sun * .01) - map(p)) / .01;
        C *= rs == f ? vec3(1) : sphere ? vec3(1, .4, 0) : vec3(0, .4, 1);
    }

    C = mix(C, vec3(.0), smoothstep(0., 1e3, r*r) * (1. - smoothstep(.0, .01, rd.y)));
    
    return vec4(sqrt(C), 1.0);
    
}
            
            
            """
