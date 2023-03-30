package lk.ijse.supermarket.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.supermarket.dto.CustomerDTO;
import lk.ijse.supermarket.service.custom.CustomerService;
import lk.ijse.supermarket.service.custom.impl.CustomerServiceImpl;
import lk.ijse.supermarket.util.Navigation;
import lk.ijse.supermarket.util.Route;

import java.io.IOException;
import java.util.Optional;

public class CustomerManageFormController {
    public AnchorPane ManageCustomerContext;
    public AnchorPane DashboardContext;

    public TextField txtCusID;
    public TextField txtCusName;
    public TextField txtCusAddress;
    public TextField txtCustomerSalary;

    public TableView<CustomerDTO> tbCustomer;
    public TableColumn<CustomerDTO,String> colCusID;
    public TableColumn<CustomerDTO,String> colCusName;
    public TableColumn<CustomerDTO,String> colCusAddress;
    public TableColumn<CustomerDTO,String> colCusSalary;

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public void initialize(){
        colCusName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        colCusAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCusSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        setTable();
    }

    public void setTable(){
        ObservableList<CustomerDTO> customers = FXCollections.observableArrayList(customerService.getAllCustomer());
        tbCustomer.setItems(customers);
    }

    public CustomerDTO collectData(){
        return new CustomerDTO(txtCusID.getText(),txtCusName.getText(),txtCusAddress.getText(),Double.parseDouble(txtCustomerSalary.getText()));
    }

    public void setData(CustomerDTO customer){
        txtCusID.setText(customer.getCId());
        txtCusName.setText(customer.getCusName());
        txtCusAddress.setText(customer.getAddress());
        txtCustomerSalary.setText(String.valueOf(customer.getSalary()));
    }


    public void AddCustomerOnAction(ActionEvent actionEvent) {
        CustomerDTO customer = collectData();
        boolean b = customerService.addCustomer(customer);
        if(b){
            new Alert(Alert.AlertType.INFORMATION,"Customer Added Success..!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Customer Adding Failed").show();
        }
    }

    public void UpdateCustomerOnAction(ActionEvent actionEvent) {
        boolean b = customerService.updateCustomer(collectData());
        if(b){
            new Alert(Alert.AlertType.INFORMATION,"Update Customer Success..!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Update Customer Failed").show();
        }
    }

    public void DeleteCustomerOnAction(ActionEvent actionEvent) {
        CustomerDTO customerDTO = customerService.searchCustomer(txtCusID.getText());
        if(customerDTO==null){
            new Alert(Alert.AlertType.ERROR,"Customer Not Found").show();
            return;
        }
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.WARNING, "Do You Want To Delete : " + customerDTO.getCId() + " : " + customerDTO.getCusName() +
                " From The System", ButtonType.YES, ButtonType.NO).showAndWait();
        if(buttonType.get().getText().equalsIgnoreCase("no")){
            new Alert(Alert.AlertType.INFORMATION,"Customer Not Deleted").show();
            return;
        }
        if(customerService.deleteCustomer(customerDTO)){
            new Alert(Alert.AlertType.INFORMATION,"Customer Deleted Success").show();
        }
    }

    public void searchCustomerOnAction(ActionEvent actionEvent) {
        setData(customerService.searchCustomer(txtCusID.getText()));
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        txtCusID.clear();
        txtCusName.clear();
        txtCusAddress.clear();
        txtCustomerSalary.clear();
    }

    public void RefreshOnAction(ActionEvent actionEvent) {
        txtCusID.setText(customerService.getNewId());
    }

    public void backToMenuOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.DASHBOARD,DashboardContext);
    }
}
