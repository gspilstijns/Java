package com.crm.miniCRM.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.crm.miniCRM.dto.AddressDto;
import com.crm.miniCRM.dto.PersonAddressDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.dto.PersonImportDto;
import com.crm.miniCRM.mappers.addressMapper;
import com.crm.miniCRM.mappers.personAddressMapper;
import com.crm.miniCRM.mappers.personMapper;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.PersonAddress;
import com.crm.miniCRM.model.persistence.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonRepository personService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private PersonAddressRepository personAddressRepository;

    @GetMapping
    public String getpersons(Model model) {
        List < PersonDto > personDtos = getActivePersons ( );
        model.addAttribute("persons", personDtos);
        return "persons/persons";
    }

    @GetMapping("/persondetails/{id}")
    public String getPersonAddressById(@PathVariable long id, Model model){
        List< AddressDto > addressDtos = new ArrayList<>();
        List< PersonAddressDto > personAddressDtos = new ArrayList<>();

        Person person = personService.findById ( id );

        person.getPerson_address ().iterator ()
                .forEachRemaining ( a -> {
                    addressDtos.add ( addressMapper.convertToDto ( a ) );
                    Optional < PersonAddress > personAddress= personAddressRepository.findById ( getPersonAddressID (a.getId (),person.getId ()));
                    if (personAddress.isPresent ()){personAddressDtos.add ( personAddressMapper.convertToDto ( personAddress) );}
                });

        model.addAttribute("addresses", addressDtos);
        model.addAttribute("person", personMapper.convertToDto ( person));
        model.addAttribute("personAddress", personAddressDtos);

        //todo: make frontend
        //todo: add button to person frontend for link
        //todo: make edit window
        return "persons/person-detail";
    }


    @GetMapping("/new")
    public String newperson(Model model) {
        model.addAttribute("person", new PersonDto());
        return "persons/new-person";
    }

    @PostMapping
    public String addperson(PersonDto person) {
        person.setArchived ( false );
        personService.save(personMapper.convertToEntity (person));
        return "redirect:/persons";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ){
        Person person = personService.findById ( id );
        model.addAttribute ( "person", personMapper.convertToDto ( person ) );
        return "persons/update-person";

    }
    @PostMapping("/edit/{id}")
    public String updateUser( @PathVariable("id") long id, PersonDto personDto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            personDto.setId(id);
            return "persons/update-person";
        }

        personService.save( personMapper.convertToEntity ( personDto ));
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser( @PathVariable("id") long id, Model model ){
        Person person = personService.findById ( id );
        person.setArchived ( true );
        person.getMember ().removeAll ( person.getMember () );
        personService.save ( person );
        //model.addAttribute ( "person", personMapper.convertToDto ( person ) );
        return "redirect:/persons";

    }


    @GetMapping("/import")
    public String importUsers(){

        return "persons/upload-person";
    }
    //// Sources
    //// https://attacomsian.com/blog/spring-boot-thymeleaf-file-upload
    //// https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
    //// https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html
    //// https://semantic-ui.com/

    private final String UPLOAD_DIR = "C:\\Temp\\";


    @PostMapping("/upload")
    public String uploadFile( @RequestParam("file") MultipartFile file, RedirectAttributes attributes) {

        List< PersonImportDto > personImportDtos = new ArrayList <> (  );
        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/persons/import";
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // save the file on the local file system
        try {
           Path path = Paths.get(UPLOAD_DIR + fileName);
           Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            FileReader filereader = new FileReader(path.toString ());
            CSVParser parser = new CSVParserBuilder ().withSeparator(';').build();

            personImportDtos = new CsvToBeanBuilder(filereader)
                    .withSeparator(';')
                    .withType ( PersonImportDto.class )
                    .build()
                    .parse ();

            personImportDtos.forEach ( p ->
                personService.save ( personMapper.convertToEntityBulkImport ( p ))
            );


         } catch (IOException e) {
             e.printStackTrace();
         }

        // return success response
        attributes.addFlashAttribute("message", "You successfully imported "+ personImportDtos.size ()  +" records from " + fileName + '!');

        return "redirect:/persons/import";
    }





    ////////////////////////////
    /// Extracted methods below
    ////////////////////////////
    private PersonAddressID getPersonAddressID( long idAddress, long idPerson) {
        PersonAddressID paID = new PersonAddressID();
        paID.setAddress_ID(idAddress);
        paID.setPerson_ID(idPerson);
        return paID;
    }

    private List < PersonDto > getActivePersons () {
        Iterable<Person> persons = personService.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        persons.forEach(p ->{
            if (!p.getArchived ()){
                personDtos.add(personMapper.convertToDto (p));
            }
        } );
        return personDtos;
    }


}
