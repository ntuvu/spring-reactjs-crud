import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);

  const getAllEmployees = () => {
    EmployeeService.index()
      .then((res) => {
        setEmployees(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getAllEmployees();
  }, []);

  const deleteEmployee = (id) => {
    EmployeeService.delete(id)
      .then((res) => {
        getAllEmployees();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className='container'>
      <h2 className='text-center'>List Employees</h2>
      <Link to='/add' className='btn btn-primary mb-2'>
        Add Employee
      </Link>
      <table className='table table-bordered table-striped'>
        <thead>
          <th>Employee ID</th>
          <th>Employee First name</th>
          <th>Employee Last name</th>
          <th>Employee Email</th>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
              <td>
                <Link className='btn btn-info' to={`/edit/${employee.id}`}>
                  Edit
                </Link>
                <button
                  className='btn btn-danger'
                  onClick={() => deleteEmployee(employee.id)}
                  style={{ marginLeft: '12px' }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
