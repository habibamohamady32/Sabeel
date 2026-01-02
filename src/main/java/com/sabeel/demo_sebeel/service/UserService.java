package com.sabeel.demo_sebeel.service;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import com.sabeel.demo_sebeel.dto.UserRequestDto;
import com.sabeel.demo_sebeel.entity.AcceptanceData;
import com.sabeel.demo_sebeel.entity.ManagementData;
import com.sabeel.demo_sebeel.entity.User;
import com.sabeel.demo_sebeel.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabeel.demo_sebeel.dto.ImportReport;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;



import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequestDto dto) {
        User user = new User();
        user.setStudentName(dto.getStudentName());
        user.setAge(dto.getAge());
        user.setNationalId(dto.getNationalId());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPlaceOfWork(dto.getPlaceOfWork());
        user.setJob(dto.getJob());
        user.setAddress(dto.getAddress());
        user.setLevelOfStudy(dto.getLevelOfStudy());
        user.setStatus(dto.getStatus());

        AcceptanceData acceptance = new AcceptanceData();
        acceptance.setLastSavingAmount(dto.getLastSavingAmount());
        acceptance.setLevel(dto.getLevel());
        acceptance.setExamineTeacherName(dto.getExamineTeacherName());

        ManagementData management = new ManagementData();
        management.setActualAttendanceDate(dto.getActualAttendanceDate());
        management.setSpecifiedTime(dto.getSpecifiedTime());
        management.setInstituteFees(dto.getInstituteFees());
        management.setStudentGroupId(dto.getStudentGroupId());
        management.setReceiptNumber(dto.getReceiptNumber());
        management.setSubmissionDate(dto.getSubmissionDate());
        management.setReceiver(dto.getReceiver());

        user.setAcceptance(acceptance);
        user.setManagement(management);

        return userRepository.save(user);
    }

    public Optional<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return Optional.ofNullable(users);
    }

    public Optional<User> getUserById(long id) {
        User user = userRepository.getUserById(id);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByNationalId(String id) {
        User user = userRepository.getUserByNationalId(id);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByName(String name) {
        User user = userRepository.getUserByStudentName(name);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        User user = userRepository.getUserByPhoneNumber(phoneNumber);
        return Optional.ofNullable(user);
    }

    public Optional<List<User>> findByStatus(UserStatus status) {
        List<User> users = userRepository.getUserByStatus(status);
        return Optional.ofNullable(users);
    }

    public User updateStatus(long id, UserStatus status) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setStatus(status);
            userRepository.save(existingUser);
            return existingUser;
        } else {
            throw new EntityNotFoundException("User does not exist");
        }
    }

    public User updateUser(long id, UserRequestDto userDto) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setStudentName(userDto.getStudentName());
            existingUser.setPhoneNumber(userDto.getPhoneNumber());
            existingUser.setStatus(userDto.getStatus());
            existingUser.setNationalId(userDto.getNationalId());
            existingUser.setAddress(userDto.getAddress());
            existingUser.setLevelOfStudy(userDto.getLevelOfStudy());
            existingUser.setAge(userDto.getAge());
            existingUser.setPlaceOfWork(userDto.getPlaceOfWork());
            existingUser.setJob(userDto.getJob());
            existingUser.getAcceptance().setLastSavingAmount(userDto.getLastSavingAmount());
            existingUser.getAcceptance().setLevel(userDto.getLevel());
            existingUser.getAcceptance().setExamineTeacherName(userDto.getExamineTeacherName());
            existingUser.getManagement().setActualAttendanceDate(userDto.getActualAttendanceDate());
            existingUser.getManagement().setSpecifiedTime(userDto.getSpecifiedTime());
            existingUser.getManagement().setInstituteFees(userDto.getInstituteFees());
            existingUser.getManagement().setStudentGroupId(userDto.getStudentGroupId());
            existingUser.getManagement().setReceiptNumber(userDto.getReceiptNumber());
            existingUser.getManagement().setSubmissionDate(userDto.getSubmissionDate());
            existingUser.getManagement().setReceiver(userDto.getReceiver());

            return userRepository.save(existingUser);
        }
        else {
            throw new EntityNotFoundException("User does not exist");
        }
    }

    public void deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }


    @Transactional
    public ImportReport importFromExcel(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) throw new IllegalArgumentException("Empty file");
        String fn = Optional.ofNullable(file.getOriginalFilename()).orElse("").toLowerCase();
        if (!fn.endsWith(".xlsx")) throw new IllegalArgumentException("Only .xlsx files are supported");

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        ImportReport report = new ImportReport();
        List<User> toPersist = new ArrayList<>();

        try (InputStream is = file.getInputStream();
             Workbook wb = WorkbookFactory.create(is)) {

            Sheet sheet = wb.getSheetAt(0);
            if (sheet == null) throw new IllegalArgumentException("No sheet found");

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;

                try {
                    UserRequestDto dto = new UserRequestDto();
                    int i = 0;

                    i++;
                    dto.setExamineTeacherName(getString(row.getCell(i++)));
                    dto.setLastSavingAmount(getString(row.getCell(i++)));
                    dto.setLevel(getString(row.getCell(i++)));
                    dto.setAddress(getString(row.getCell(i++)));
                    dto.setAge(getInteger(row.getCell(i++)));
                    dto.setJob(getString(row.getCell(i++)));
                    dto.setLevelOfStudy(getString(row.getCell(i++)));
                    dto.setActualAttendanceDate(parseLocalDate(row.getCell(i++)));
                    dto.setInstituteFees(getString(row.getCell(i++)));
                    dto.setReceiptNumber(getString(row.getCell(i++)));
                    dto.setReceiver(getString(row.getCell(i++)));
                    dto.setSpecifiedTime(getString(row.getCell(i++)));
                    dto.setStudentGroupId(getString(row.getCell(i++)));
                    dto.setSubmissionDate(parseLocalDate(row.getCell(i++)));
                    dto.setNationalId(getString(row.getCell(i++)));
                    dto.setPhoneNumber(getString(row.getCell(i++)));
                    dto.setPlaceOfWork(getString(row.getCell(i++)));
                    dto.setStudentName(getString(row.getCell(i++)));
                    dto.setStatus(parseStatus(getString(row.getCell(i++))));

                    Set<ConstraintViolation<UserRequestDto>> v = validator.validate(dto);
                    if (!v.isEmpty()) {
                        report.addError(r + 1, v.stream()
                                .map(err -> err.getPropertyPath() + " " + err.getMessage())
                                .collect(Collectors.joining("; ")));
                        continue;
                    }

                    if (userRepository.existsByNationalId(dto.getNationalId())) {
                        report.addSkipped(r + 1, "Duplicate nationalId: " + dto.getNationalId());
                        continue;
                    }

                    User u = new User();
                    u.setStudentName(dto.getStudentName());
                    u.setAge(dto.getAge());
                    u.setNationalId(dto.getNationalId());
                    u.setPhoneNumber(dto.getPhoneNumber());
                    u.setPlaceOfWork(dto.getPlaceOfWork());
                    u.setJob(dto.getJob());
                    u.setAddress(dto.getAddress());
                    u.setLevelOfStudy(dto.getLevelOfStudy());
                    u.setStatus(dto.getStatus());

                    AcceptanceData acc = new AcceptanceData();
                    acc.setLastSavingAmount(dto.getLastSavingAmount());
                    acc.setLevel(dto.getLevel());
                    acc.setExamineTeacherName(dto.getExamineTeacherName());
                    u.setAcceptance(acc);

                    ManagementData mgmt = new ManagementData();
                    mgmt.setActualAttendanceDate(dto.getActualAttendanceDate());
                    mgmt.setSpecifiedTime(dto.getSpecifiedTime());
                    mgmt.setInstituteFees(dto.getInstituteFees());
                    mgmt.setStudentGroupId(dto.getStudentGroupId());
                    mgmt.setReceiptNumber(dto.getReceiptNumber());
                    mgmt.setSubmissionDate(dto.getSubmissionDate());
                    mgmt.setReceiver(dto.getReceiver());
                    u.setManagement(mgmt);

                    toPersist.add(u);
                    report.incrementSuccess();

                } catch (Exception e) {
                    report.addError(r + 1, e.getMessage());
                }
            }
        }

        if (!toPersist.isEmpty()) userRepository.saveAll(toPersist);
        return report;
    }

    private String getString(Cell cell) {
        if (cell == null) return null;
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    yield cell.getLocalDateTimeCellValue().toLocalDate().toString();
                } else {
                    cell.setCellType(CellType.STRING);
                    yield cell.getStringCellValue().trim();
                }
            }
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> {
                try { yield cell.getStringCellValue().trim(); }
                catch (Exception e) {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        yield cell.getLocalDateTimeCellValue().toLocalDate().toString();
                    }
                    cell.setCellType(CellType.STRING);
                    yield cell.getStringCellValue().trim();
                }
            }
            default -> null;
        };
    }
    private Integer getInteger(Cell cell) {
        String s = getString(cell);
        if (s == null || s.isBlank()) return null;
        return Integer.valueOf(s);
    }
    private LocalDate parseLocalDate(Cell cell) {
        if (cell == null) return null;
        if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
            return cell.getLocalDateTimeCellValue().toLocalDate();
        }
        String s = getString(cell);
        return (s == null || s.isBlank()) ? null : LocalDate.parse(s);
    }
    private UserStatus parseStatus(String raw) {
        if (raw == null || raw.isBlank()) return null;

        try {
            return UserStatus.valueOf(raw.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Invalid status: " + raw +
                            " (Allowed: " + Arrays.toString(UserStatus.values()) + ")"
            );
        }
    }

    public byte[] generateUsersTemplate() throws Exception {
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("users");

            String[] headers = {
                    "id",
                    "examine_teacher_name",
                    "last_saving_amount",
                    "level",
                    "address",
                    "age",
                    "job",
                    "level_of_study",
                    "actual_attendance_date",
                    "institute_fees",
                    "receipt_number",
                    "receiver",
                    "specified_time",
                    "student_group_id",
                    "submission_date",
                    "national_id",
                    "phone_number",
                    "place_of_work",
                    "student_name",
                    "status"
            };

            CellStyle headerStyle = wb.createCellStyle();
            Font bold = wb.createFont();
            bold.setBold(true);
            headerStyle.setFont(bold);

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell c = headerRow.createCell(i);
                c.setCellValue(headers[i]);
                c.setCellStyle(headerStyle);
            }
            Row sample = sheet.createRow(1);
            int i = 0;
            sample.createCell(i++).setCellValue("");
            sample.createCell(i++).setCellValue("Sheikh Mahmoud");
            sample.createCell(i++).setCellValue("500");
            sample.createCell(i++).setCellValue("10 Parts");
            sample.createCell(i++).setCellValue("Cairo, Nasr City");
            sample.createCell(i++).setCellValue(21);
            sample.createCell(i++).setCellValue("Accountant");
            sample.createCell(i++).setCellValue("Level 1");
            sample.createCell(i++).setCellValue("2025-10-01");
            sample.createCell(i++).setCellValue("250");
            sample.createCell(i++).setCellValue("RCPT20240601");
            sample.createCell(i++).setCellValue("Mohamed Youssef");
            sample.createCell(i++).setCellValue("10:00 AM");
            sample.createCell(i++).setCellValue("Group A");
            sample.createCell(i++).setCellValue("2025-10-02");
            sample.createCell(i++).setCellValue("29805123456789");
            sample.createCell(i++).setCellValue("01012345678");
            sample.createCell(i++).setCellValue("ABC Company");
            sample.createCell(i++).setCellValue("Ahmed Ali");
            sample.createCell(i++).setCellValue(1);

            for (int col = 0; col < headers.length; col++) {
                sheet.autoSizeColumn(col);
            }

            try (java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream()) {
                wb.write(bos);
                return bos.toByteArray();
            }
        }
    }


}

