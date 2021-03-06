# Collada-Based Serializers

## Overview

This projects contains the following serializers: Collada (DAE), Google Earth (KMZ), and OpenGL Transmission Format (glTF). The Collada format provides is the primary serializer in this package. It is used to generate Collada 3d model files with the extension of "DAE". The KMZ and glTF formats provide serializers that build on the result of the Collada serializer. For KMZ, the output is a KMZ file, which is a ZIP consisting of a KML file of XML and a Collada model file. For glTF, the output may be retrieved as a ZIP file or a JSON file. For glTF's output, these files contain in some form: a binary file (project-name.bin), a JSON file (project-name.json), a vertex shader GLSL (project-nameXFS.glsl), and a fragment shader GLSL (project-nameXVS.glsl). The glTF is dependent upon the program collada2gltf being available on the path of the server operating system of the BIMServer.


### Collada (DAE)

Collada files currently present each IFC object as its own set of geometry. One camera and one directional light are included. This serializer currently does not consider any texture data, but does provide colored materials in conjunction with the lighting type "phong".


### Google Earth (KMZ)

KMZ files provide a placemark on planet Earth where the IFC object would exist and the geometry to display it. 


### OpenGL Transmission Format (glTF)

<<<<<<< 1.3
This serializer depends on the collada2gltf exporter. It must be available to be executed from the command-line. Download the exporter here: https://github.com/KhronosGroup/glTF/wiki/converter
=======
#### Dependencies

This serializer depends on the collada2gltf exporter. It must be available to be executed from the command-line. In the case of applicable operating systems (Windows & MacOSX), binary versions of the exporter are provided (V0.6). For convenience in updating just the exporter, the binaries are copied to a directory beneath BIMServer's "tmp" directory, so that the paths look like: _path-to-bim-server/home-directory/tmp/gltf_, _path-to-bim-server/home-directory/tmp/gltf/collada2gltf_, _path-to-bim-server/home-directory/tmp/gltf/collada2gltf.exe_

In the case of MacOSX, placing or replacing the generated "collada2gltf" file will update the plugin to the current version. In the case of Windows, placing or replacing the generated "collada2gltf.exe" file will update the plugin to the current version. For all other operating systems, it is necessary to build the exporter application. In these scenarios, the plugin expects the operating system to resolve the name "collada2gltf" and will not attempt to load any pre-packaged binaries. 

Download the exporter, view building instructions, stay up-to-date here: https://github.com/KhronosGroup/glTF/wiki/converter

#### Output Goals
>>>>>>> 448f76b Changes mark-down documentation of paths to be italics.

This serializer wraps the set of files generated by the collada2gltf exporter. For example, the JSON version of the plugin results in something like the following for a project called "P1":

```javascript
{
	"P1.bin": "data:text/plain;base64,AAABAAIAAgABA...AAAIA/",
	"P1.json": "data:text/plain;base64,ew0KICAgICJhY2N...CAgIH0NCn0=",
	"P10FS.glsl": "data:text/plain;base64,cHJlY2lzaW9...sNCn0NCg==",
	"P10VS.glsl": "data:text/plain;base64,cHJlY2lzaW9u...M7DQp9DQo=",
}
```

The ZIP version of the plugin results in those same files (P1.bin, P1.json, P10FS.glsl, P10VS.glsl) being put into a ZIP file instead.

Some of the plugins that interface with the serializer allow the serializer to inform the collada2gltf exporter to use geometry compression, resulting in a significantly smaller BIN file.
