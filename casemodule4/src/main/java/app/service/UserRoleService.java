//package app.service;
//
////import app.model.UserRole;
//import app.repository.repoInterface.IUserRoleRepo;
//import app.service.serviceInterface.IUserRolesService;
//
//import java.util.List;
//
//public class UserRoleService implements IUserRolesService {
//
//    IUserRoleRepo userRoleRepo;
//
//    @Override
//    public List<UserRole> findByUserName(String userName) {
//        try {
//            List<UserRole> listRoles = (List<UserRole>) userRoleRepo.findAllByUserName(userName);
//            return listRoles;
//        }
//        catch (Exception e){
//            return null;
//        }
//    }
//
//    @Override
//    public void add(UserRole userRole) {
//        userRoleRepo.save(userRole);
//    }
//
//    @Override
//    public void edit(UserRole user) {
//        userRoleRepo.save(user);
//    }
//
//    @Override
//    public void remove(UserRole userRole) {
//        userRoleRepo.delete(userRole);
//    }
//
//    @Override
//    public List<UserRole> findAll() {
//        List<UserRole> list = (List<UserRole>)userRoleRepo.findAll();
//        return list;
//    }
//}
