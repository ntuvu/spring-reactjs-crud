import axios from 'axios';

const EMPLOYEE_REST_API_URL = 'http://localhost:8080/api/employees/';

class EmployeeService {
  index() {
    return axios.get(EMPLOYEE_REST_API_URL);
  }

  create(employee) {
    return axios.post(EMPLOYEE_REST_API_URL, employee)
  }

  show(id) {
    return axios.get(EMPLOYEE_REST_API_URL + id);
  }

  update(id, employee) {
    return axios.patch(EMPLOYEE_REST_API_URL + id, employee);
  }

  delete(id) {
    return axios.delete(EMPLOYEE_REST_API_URL + id);
  }
}

export default new EmployeeService();
