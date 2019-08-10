package com.employee.crud;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> userData = EmployeeData.userData();

    public List<Employee> getAllUser() {
        return userData;
    }

    public void addUser(Employee employee) {

        userData.add(employee);
    }

    public void updateUserById(int userId, Employee employee) throws Exception {
        Employee userInfo = getUserById(userId);
        userInfo.setName(employee.getName());
        save(userInfo);
    }

    public void deleteUserById(int userId) throws Exception {
        deleteById(userId);
    }

    private Employee getUserById(int userId) throws Exception {
        return userData.stream()
                .filter(item -> item.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new Exception(
                        String.format("Unknown User with id: %s", userId)
                ));
    }

    private void save(Employee userInfo) {
        int index = 0;
        for(int i = 0; i<userData.size(); i++){
            if(userData.get(i).getId() == userInfo.getId()){
                index = i;
            }
        }
        userData.set(index, userInfo);
    }

    private void deleteById(int userId) throws Exception {
        Employee user = getUserById(userId);
        userData.remove(user);
    }
}
