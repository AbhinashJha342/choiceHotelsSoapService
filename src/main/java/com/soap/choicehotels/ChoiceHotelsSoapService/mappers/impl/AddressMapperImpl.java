package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.AddressDto;

public class AddressMapperImpl implements Mapper<AddressDto, Address> {


    @Override
    public Address map(AddressDto source) {
        if(source == null)
            return null;
        AddressLines addressLines = new AddressLinesMapperImpl().map(source.getAddressLines());
        return new Address(source.getCity(), source.getState(), source.getPostalCode(), addressLines);
    }
}
