package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.AddVehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.VehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.entity.*;
import rs.ac.singidunum.fir.cartraderbackend.exception.auth.UserForbiddenException;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.VehicleNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.*;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ModelService modelService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private FuelTypeService fuelTypeService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DoorCountTypeService doorCountTypeService;
    @Autowired
    private ColorTypeService colorTypeService;
    @Autowired
    private GearboxTypeService gearboxTypeService;
    @Autowired
    private SecurityFeatureRepository securityFeatureRepository;
    @Autowired
    private EquipmentFeatureRepository equipmentFeatureRepository;
    @Autowired
    private VehicleSecurityFeatureRepository vehicleSecurityFeatureRepository;
    @Autowired
    private VehicleEquipmentFeatureRepository vehicleEquipmentFeatureRepository;

    @Transactional
    public VehicleDTO mapToDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setId(vehicle.getId());
            vehicleDTO.setManufacturer(vehicle.getModel().getManufacturer().getName());
            vehicleDTO.setModel(vehicle.getModel().getName());
            vehicleDTO.setFullModelName(vehicle.getModel().getManufacturer().getName() + " " + vehicle.getModel().getName());
            vehicleDTO.setGearboxType(vehicle.getGearboxType().getName());
            vehicleDTO.setCategory(vehicle.getCategory().getName());
            vehicleDTO.setFuelType(vehicle.getFuelType().getName());
            vehicleDTO.setColorType(vehicle.getColorType().getName());
            vehicleDTO.setDoorCountType(vehicle.getDoorCountType().getName());
            vehicleDTO.setExcerpt(vehicle.getExcerpt());
            vehicleDTO.setDescription(vehicle.getDescription());
            vehicleDTO.setEngineCapacity(vehicle.getEngineCapacity());
            vehicleDTO.setEnginePower(vehicle.getEnginePower());
            vehicleDTO.setMileage(vehicle.getMileage());
            vehicleDTO.setPrice(vehicle.getPrice());
            vehicleDTO.setFromOwner(vehicle.isFromOwner());
            vehicleDTO.setRegistrationExpiresAt(vehicle.getRegistrationExpiresAt());
            vehicleDTO.setCreatedAt(vehicle.getCreatedAt());
            System.out.println(vehicle.getCreatedAt());
            vehicleDTO.setYear(vehicle.getYear());

            if (vehicle.getVehicleSecurityFeatures() == null) {
                vehicleDTO.setSecurityFeatures(new HashSet<>());
            } else {
                vehicleDTO.setSecurityFeatures(vehicle.getVehicleSecurityFeatures().stream().map(vehicleSecurityFeature -> vehicleSecurityFeature.getSecurityFeature().getName()).collect(Collectors.toSet()));
            }

            if (vehicle.getVehicleEquipmentFeatures() == null) {
                vehicleDTO.setEquipmentFeatures(new HashSet<>());
            } else {
                vehicleDTO.setEquipmentFeatures(
                    vehicle.getVehicleEquipmentFeatures().stream().map(vehicleEquipmentFeature -> vehicleEquipmentFeature.getEquipmentFeature().getName()).collect(Collectors.toSet())
                );
            }

            if (vehicle.getPhotos() == null) {
                vehicleDTO.setPhotos(new HashSet<>());
            } else {
                vehicleDTO.setPhotos(
                        vehicle.getPhotos().stream().map(photo -> photo.getPath()).collect(Collectors.toSet())
                );
            }


            vehicleDTO.setUser(userService.mapToDto(vehicle.getUser()));
        return vehicleDTO;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<VehicleDTO> getAllVehicleDTOs() {
        return vehicleRepository.findAll()
                                .stream()
                                .map(this::mapToDTO)
                                .collect(Collectors.toList());
    }

    public VehicleDTO getVehicleDTOById(Long vehicleId) {
        return mapToDTO(vehicleRepository.findById(vehicleId).get());
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void updateVehicleById(Long vehicleId, Vehicle updatedVehicle) {
        // todo
    }

    public void deleteVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundException());

        User currentUser = authService.getCurrentUser();

        if (currentUser.getId() != vehicle.getUser().getId()) {
            throw new UserForbiddenException();
        }
        vehicleRepository.deleteById(vehicleId);
    }

    @Transactional
    public List<VehicleDTO> search(Map<String, String> searchParameters) {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        if (searchParameters.containsKey("manufacturer")) {
            vehicles = vehicles.stream()
                                .filter(vehicle -> vehicle.getModel()
                                                            .getManufacturer()
                                                            .getName()
                                                            .equals(searchParameters.get("manufacturer")))
                                .collect(Collectors.toList());
        }

        if (searchParameters.containsKey("model")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getModel().getName().equals(searchParameters.get("model"))).collect(Collectors.toList());
        }

        if (searchParameters.containsKey("fuelType")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getFuelType().getName().equals(searchParameters.get("fuelType"))).collect(Collectors.toList());
        }

        if (searchParameters.containsKey("category")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getCategory().getName().equals(searchParameters.get("category"))).collect(Collectors.toList());
        }

        if (searchParameters.containsKey("colorType")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getColorType().getName().equals(searchParameters.get("colorType"))).collect(Collectors.toList());
        }

        if (searchParameters.containsKey("colorType")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getColorType().getName().equals(searchParameters.get("colorType"))).collect(Collectors.toList());
        }

        if (searchParameters.containsKey("gearboxType")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getGearboxType().getName().equals(searchParameters.get("gearboxType"))).collect(Collectors.toList());
        }

        if (searchParameters.containsKey("doorCount")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getDoorCountType().getName().equals(searchParameters.get("doorCount"))).collect(Collectors.toList());
        }

        // CENA

        if (searchParameters.containsKey("startingPrice") && searchParameters.containsKey("endingPrice")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getPrice() > Integer.parseInt(searchParameters.get("startingPrice")) && vehicle.getPrice() < Integer.parseInt(searchParameters.get("endingPrice")))
                    .collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("startingPrice")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getPrice() > Integer.parseInt(searchParameters.get("startingPrice"))).collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("endingPrice")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getPrice() < Integer.parseInt(searchParameters.get("endingPrice"))).collect(Collectors.toList());
        }

        // Kubikaza

        if (searchParameters.containsKey("startingCcm") && searchParameters.containsKey("endingCcm")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getEngineCapacity() > Integer.parseInt(searchParameters.get("startingCcm")) && vehicle.getEngineCapacity() < Integer.parseInt(searchParameters.get("endingCcm")))
                    .collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("startingPrice")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getEngineCapacity() > Integer.parseInt(searchParameters.get("startingCcm"))).collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("endingPrice")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getEngineCapacity() < Integer.parseInt(searchParameters.get("endingCcm"))).collect(Collectors.toList());
        }

        // KW

        if (searchParameters.containsKey("startingKw") && searchParameters.containsKey("endingKw")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getEnginePower() > Integer.parseInt(searchParameters.get("startingKw")) && vehicle.getEnginePower() < Integer.parseInt(searchParameters.get("endingKw")))
                    .collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("startingPrice")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getEnginePower() > Integer.parseInt(searchParameters.get("startingKw"))).collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("endingPrice")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getEnginePower() < Integer.parseInt(searchParameters.get("endingKw"))).collect(Collectors.toList());
        }

        // GODINA

        if (searchParameters.containsKey("startingYear") && searchParameters.containsKey("endingYear")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getYear() > Integer.parseInt(searchParameters.get("startingYear")) && vehicle.getYear() < Integer.parseInt(searchParameters.get("endingYear")))
                    .collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("startingYear")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getYear() > Integer.parseInt(searchParameters.get("startingYear"))).collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("endingYear")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getYear() < Integer.parseInt(searchParameters.get("endingYear"))).collect(Collectors.toList());
        }

        // KILOMETRAZA

        if (searchParameters.containsKey("startingMileage") && searchParameters.containsKey("endingMileage")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getMileage() > Integer.parseInt(searchParameters.get("startingMileage")) && vehicle.getMileage() < Integer.parseInt(searchParameters.get("endingMileage")))
                    .collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("startingMileage")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getMileage() > Integer.parseInt(searchParameters.get("startingMileage"))).collect(Collectors.toList());
        }

        else if (searchParameters.containsKey("endingMileage")) {
            vehicles = vehicles.stream().filter(vehicle -> vehicle.getMileage() < Integer.parseInt(searchParameters.get("endingMileage"))).collect(Collectors.toList());
        }

        return vehicles.stream().map(vehicle -> this.mapToDTO(vehicle)).collect(Collectors.toList());
    }

    public void uploadImageForVehicle(Long vehicleId, MultipartFile imageFile) {
        String folder = "static/";


        try {
            imageFile.transferTo(new File("C:\\Users\\lgajic\\Desktop\\cartrader-backend\\src\\main\\resources\\static\\" + imageFile.getOriginalFilename()));

            String imagePath = "http://192.168.1.106/images/" + imageFile.getOriginalFilename();
            Photo photo = new Photo();

            Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundException());
            photo.setVehicle(vehicle);
            photo.setPath(imagePath);

            photoRepository.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        try {
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(folder + imageFile.getOriginalFilename());
            System.out.println(path);
            Files.write(path, bytes);

            // Ovde dodati JPA impl za upload slike!
            System.out.println("SLIKA SACUVANA");

        } catch (Exception e) {
            //throw new CarTraderException("Doslo je do greske prilikom dodavanja slike");

            System.out.println("GRESKA SLIKA: ");
            e.printStackTrace();
        }*/
    }

    @Transactional
    public VehicleDTO addVehicle(AddVehicleDTO addVehicleDTO) {
        Vehicle vehicle = new Vehicle();

        Model model = modelService.getModelById(addVehicleDTO.getModelId());
        FuelType fuelType = fuelTypeService.getFuelTypeById(addVehicleDTO.getFuelTypeId());
        Category category = categoryService.getCategoryById(addVehicleDTO.getCategoryId());
        DoorCountType doorCountType = doorCountTypeService.getDoorCountTypeById(addVehicleDTO.getDoorCountTypeId());
        ColorType colorType = colorTypeService.getColorTypeById(addVehicleDTO.getColorTypeId());
        GearboxType gearboxType = gearboxTypeService.getGearboxTypeById(addVehicleDTO.getGearboxTypeId());
        int engineCapacity = addVehicleDTO.getEngineCapacity();
        int enginePower = addVehicleDTO.getEnginePower();
        int year = addVehicleDTO.getYear();
        int price = addVehicleDTO.getPrice();
        int mileage = addVehicleDTO.getMileage();
        boolean isFromOwner = addVehicleDTO.isFromOwner();
        System.out.println(addVehicleDTO.isFromOwner());
        String registrationExpiresAt = addVehicleDTO.getRegistrationExpiresAt();
        String excerpt = addVehicleDTO.getExcerpt();
        String description = addVehicleDTO.getDescription();

        User user = userService.getUserById(addVehicleDTO.getUserId());

        List<String> securityFeatures = new ArrayList<>(addVehicleDTO.getSecurityFeatures());
        List<String> equipmentFeatures = new ArrayList<>(addVehicleDTO.getEquipmentFeatures());

        vehicle.setModel(model);
        vehicle.setFuelType(fuelType);
        vehicle.setCategory(category);
        vehicle.setDoorCountType(doorCountType);
        vehicle.setColorType(colorType);
        vehicle.setGearboxType(gearboxType);
        vehicle.setEngineCapacity(engineCapacity);
        vehicle.setEnginePower(enginePower);
        vehicle.setYear(year);
        vehicle.setPrice(price);
        System.out.println(isFromOwner);
        vehicle.setFromOwner(isFromOwner);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = sdf.parse(registrationExpiresAt);
        } catch (ParseException e) {
            // Proveriti ovo!
            // throw new CarTraderException("PROBLEM SA DATUMOM");
            date = new Date();
        }

        vehicle.setRegistrationExpiresAt(date);

        vehicle.setMileage(mileage);
        vehicle.setExcerpt(excerpt);
        vehicle.setDescription(description);
        vehicle.setUser(user);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        long savedVehicleId = savedVehicle.getId();

        Set<SecurityFeature> sfToAdd = new HashSet<>();
        Set<EquipmentFeature> efToAdd = new HashSet<>();

        if (!securityFeatures.isEmpty()) {
            for (String s: securityFeatures) {
                SecurityFeature sf = securityFeatureRepository.findByName(s).orElse(null);
                if (sf != null) {
                    VehicleSecurityFeature vsf = new VehicleSecurityFeature();
                    vsf.setVehicle(savedVehicle);
                    vsf.setSecurityFeature(sf);
                    vehicleSecurityFeatureRepository.save(vsf);
                }
            }
        }

        if (!equipmentFeatures.isEmpty()) {
            for (String s: equipmentFeatures) {
                EquipmentFeature ef = equipmentFeatureRepository.findByName(s).orElse(null);
                if (ef != null) {
                    VehicleEquipmentFeature vef = new VehicleEquipmentFeature();
                    vef.setVehicle(savedVehicle);
                    vef.setEquipmentFeature(ef);
                    vehicleEquipmentFeatureRepository.save(vef);
                }
            }
        }
        Photo photo = new Photo();
        photo.setVehicle(vehicle);
        photo.setPath("https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg");

        photoRepository.save(photo);

        return mapToDTO(savedVehicle);
    }
}
