package com.example.core.entity;

import com.example.core.util.PropsUtil;

import java.util.Properties;

/**
 * @Description TODO
 * @Author LiuYue
 * @Date 2019/1/2
 * @Version 1.0
 */
public class ConfigContext {

    private String sourcePath;
    private String outputPath;

    private String driver;
    private String url;
    private String userName;
    private String password;


    private String targetTable;
    private String targetName;
    private String targetPackage;
    private String targetEntity;
    private String targetService;
    private String targetServiceImpl;
    private String targetController;
    private String targetDao;

    public ConfigContext(String sourcePath, String outputPath) {

        Properties properties = PropsUtil.loadProps(sourcePath+Constant.CONFIG_PROPS);
        setSourcePath(sourcePath);
        setOutputPath(outputPath);

        setDriver(PropsUtil.getString(properties, Constant.JDBC_DRIVER));
        setUrl(PropsUtil.getString(properties, Constant.JDBC_URL));
        setUserName(PropsUtil.getString(properties, Constant.JDBC_USERNAME));
        setPassword(PropsUtil.getString(properties, Constant.JDBC_PASSWORD));

        setTargetTable(PropsUtil.getString(properties, Constant.TARGET_TABLE));
        setTargetName(PropsUtil.getString(properties, Constant.TARGET_NAME));
        setTargetPackage(PropsUtil.getString(properties, Constant.TARGET_PACKAGE));
        setTargetEntity(PropsUtil.getString(properties, Constant.TARGET_ENTITY));
        setTargetService(PropsUtil.getString(properties, Constant.TARGET_SERVICE));
        setTargetServiceImpl(PropsUtil.getString(properties, Constant.TARGET_SERVICEIMPL));
        setTargetController(PropsUtil.getString(properties, Constant.TARGET_CONTROLLER));
        setTargetDao(PropsUtil.getString(properties, Constant.TARGET_DAO));
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(String targetEntity) {
        this.targetEntity = targetEntity;
    }

    public String getTargetService() {
        return targetService;
    }

    public void setTargetService(String targetService) {
        this.targetService = targetService;
    }

    public String getTargetServiceImpl() {
        return targetServiceImpl;
    }

    public void setTargetServiceImpl(String targetServiceImpl) {
        this.targetServiceImpl = targetServiceImpl;
    }

    public String getTargetController() {
        return targetController;
    }

    public void setTargetController(String targetController) {
        this.targetController = targetController;
    }

    public String getTargetDao() {
        return targetDao;
    }

    public void setTargetDao(String targetDao) {
        this.targetDao = targetDao;
    }

}
