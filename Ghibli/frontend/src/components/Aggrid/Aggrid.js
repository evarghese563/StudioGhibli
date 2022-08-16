import React,{useState,useEffect} from 'react';
import {AgGridReact} from 'ag-grid-react'
import 'ag-grid-community/dist/styles/ag-grid.css'
import 'ag-grid-community/dist/styles/ag-theme-alpine.css'
import './Aggrid.css'
const Aggrid  = () =>{

    const ghibliurl = "/ghiblis"
    
    const [rowData,setRowData] = useState([
    ]);

    const [columnDefs, setColumnDefs] = useState([
        {field:'id', sortable:true,filter:true},
        {field:'title', sortable:true,filter:true},
        {field:'director', sortable:true,filter:true},
        {field:'release_date', sortable:true,filter:true},
        {field:'running_time', sortable:true,filter:true}
    ]);

    useEffect(() => {
        fetch(ghibliurl)
        .then(result=>result.json())
        .then(rowData=>setRowData(rowData))
    }, []);



    return (
        
        <div className="aggrid">
 
            
            <div className='ag-theme-alpine'>
            <AgGridReact
            rowData={rowData}
            columnDefs={columnDefs}
            rowSelection='multiple'
            
            />


            </div>
            

                
            

            
        </div>
        
    );
}

export default Aggrid
