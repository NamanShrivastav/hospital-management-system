import {useEffect, useState} from "react";
import {getDoctors} from "../services/doctorService.js";

function AdminDashboard(){
    const [doctors, setDoctors] = useState([]);
    useEffect(() => {
        fetchDoctors();
    }, []);

    const fetchDoctors = async () => {
        try{

            const data = await getDoctors();
            setDoctors(data);
        }catch(error){
            console.log("Error fetching doctors",error);
        }
    };
    return (
        <div>
            <h1>Admin Dashboard</h1>
            <h2>Doctor List</h2>

            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Specialization</th>
                </tr>
                </thead>

                <tbody>
                {doctors.map((doctor) => (
                    <tr key={doctor.id}>
                        <td>{doctor.id}</td>
                        <td>{doctor.name}</td>
                        <td>{doctor.Specialization}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}


export default AdminDashboard;