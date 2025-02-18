package com.pvmprog.mytextwithcompose.ui.shader

import org.intellij.lang.annotations.Language

//https://www.shadertoy.com/view/XsXXDn
@Language("GLSL")
const val SHADER_SILEXARS = """
// Параметры шейдера    
                uniform float2 iResolution;      // Viewport resolution (pixels)
                uniform float  iTime;            // Shader playback time (s)
// Тело шейдера    

vec4 main(in vec2 fragCoord ){
	vec3 c;
	float l,z=iTime;
	for(int i=0;i<3;i++) {
		vec2 uv,p=fragCoord.xy/iResolution;
		uv=p;
		p-=.5;
		p.x*=iResolution.x/iResolution.y;
		z+=.07;
		l=length(p);
		uv+=p/l*(sin(z)+1.)*abs(sin(l*9.-z-z));
		c[i]=.01/length(mod(uv,1.)-.5);
	}
	vec4 fragColor=vec4(c/l,iTime);
    return fragColor;
}
"""