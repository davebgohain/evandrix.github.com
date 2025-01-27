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
package org.gephi.data.attributes;

import java.util.ArrayList;
import java.util.List;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeTable;
import org.gephi.data.attributes.api.AttributeType;
import org.gephi.data.attributes.api.AttributeUtils;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Mathieu Bastian
 * @author Martin Škurla
 */
@ServiceProvider(service = AttributeUtils.class)
public class AttributeUtilsImpl extends AttributeUtils {

    @Override
    public boolean isStringColumn(AttributeColumn column) {
        return column.getType().equals(AttributeType.STRING) || column.getType().equals(AttributeType.LIST_STRING);
    }

    @Override
    public boolean isNumberColumn(AttributeColumn column) {
        AttributeType attributeType = column.getType();
        return Number.class.isAssignableFrom(attributeType.getType());
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Comparable getMin(AttributeColumn column, Comparable[] values) {
        if (!isNumberColumn(column)) {
            throw new IllegalArgumentException("Colun must be a number column");
        }

        switch (values.length) {
            case 0:
                return null;
            case 1:
                return values[0];
            // values.length > 1
            default:
                Comparable<?> min = values[0];

                for (int index = 1; index < values.length; index++) {
                    Comparable o = values[index];
                    if (o.compareTo(min) < 0)
                        min = o;
                }

                return min;
        }
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Comparable getMax(AttributeColumn column, Comparable[] values) {
        if (!isNumberColumn(column)) {
            throw new IllegalArgumentException("Colun must be a number column");
        }

        switch (values.length) {
            case 0:
                return null;
            case 1:
                return values[0];
            // values.length > 1
            default:
                Comparable<?> max = values[0];

                for (int index = 1; index < values.length; index++) {
                    Comparable o = values[index];
                    if (o.compareTo(max) > 0)
                        max = o;
                }

                return max;
        }
    }

    @Override
    public boolean isNodeColumn(AttributeColumn column) {
        if (column == null) {
            throw new NullPointerException();
        }
        AttributeColumnImpl columnImpl = (AttributeColumnImpl) column;
        AttributeTableImpl table = columnImpl.getTable();
        if (table == table.getModel().getNodeTable()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEdgeColumn(AttributeColumn column) {
        if (column == null) {
            throw new NullPointerException();
        }
        AttributeColumnImpl columnImpl = (AttributeColumnImpl) column;
        AttributeTableImpl table = columnImpl.getTable();
        if (table == table.getModel().getEdgeTable()) {
            return true;
        }
        return false;
    }

    @Override
    public AttributeColumn[] getNumberColumns(AttributeTable table) {
        List<AttributeColumn> res = new ArrayList<AttributeColumn>();
        for (AttributeColumn c : table.getColumns()) {
            if (isNumberColumn(c)) {
                res.add(c);
            }
        }
        return res.toArray(new AttributeColumn[0]);
    }

    @Override
    public AttributeColumn[] getStringColumns(AttributeTable table) {
        List<AttributeColumn> res = new ArrayList<AttributeColumn>();
        for (AttributeColumn c : table.getColumns()) {
            if (isStringColumn(c)) {
                res.add(c);
            }
        }
        return res.toArray(new AttributeColumn[0]);
    }
}
