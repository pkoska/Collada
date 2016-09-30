package org.bimserver.collada;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Set;

import org.bimserver.collada.Collada2GLTFThread.Collada2GLTFConfiguration;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.shared.exceptions.PluginException;

public class ZippedOpenGLTransmissionFormatSerializerPlugin extends AbstractSerializerPlugin {

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		Collada2GLTFConfiguration configuration = new Collada2GLTFConfiguration(null, null, false, false, true, false, false);
		return new OpenGLTransmissionFormatSerializer(configuration, ".zip");
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}

	@Override
	public void init(PluginContext pluginContext) throws PluginException {
		// TODO: Consolidate separate OpenGL Transformation Format convenience plugins when plugin parameters are supported in the PluginImplementation of plugin.xml. 
	}

	@Override
	public String getDefaultExtension() {
		return "zip";
	}

	@Override
	public String getDefaultContentType() {
		return "application/zip";
	}

	@Override
	public String getOutputFormat(Schema schema) {
		return null;
	}
}