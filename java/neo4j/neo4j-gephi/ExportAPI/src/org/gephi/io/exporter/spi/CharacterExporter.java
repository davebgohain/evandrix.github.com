/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.io.exporter.spi;

import java.io.Writer;

/**
 * Exporter class for char streams, when an <code>Writer</code> is needed.
 *
 * @author Mathieu Bastian
 */
public interface CharacterExporter extends Exporter {

    /**
     * Set the writer where to export.
     * @param writer      the writer the exporter is to write
     */
    public void setWriter(Writer writer);
}
