/*
 * Copyright © 2010, 2011, 2012 Talis Systems Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.talis.hbase.rdf.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableDesc
{
    private String tableName ;
    private List<String> columnNames = new ArrayList<String>() ;
    
    public TableDesc( String tableName ) { this( tableName, ( String[] )null ) ; } 
    
    public TableDesc( String tableName, String... colNames )
    { 
        this.tableName = tableName ;
        if ( colNames != null )
            // Filter nulls.
            for ( int i = 0 ; i < colNames.length ; i++ )
                if ( colNames[i] != null )
                    columnNames.add( colNames[i] ) ;
    }

    public TableDesc( String tableName, List<String> colNames )
    {
        this.tableName = tableName ;
        this.columnNames = colNames ;
    }
    
    public String getTableName() 				{ return tableName ; }
    
    public boolean hasColumn( String colName ) 	{ return columnNames.contains( colName ) ; }
   
    public List<String> getColNames() 			{ return columnNames ; }
    
    public int getWidth() 						{ return columnNames.size() ; }
    
    public Iterator<String> colNames() 			{ return columnNames.iterator() ; } 
    
    @Override
    public String toString() 					{ return tableName ; }
}