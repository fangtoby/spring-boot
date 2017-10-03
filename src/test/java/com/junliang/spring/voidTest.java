package com.junliang.spring;

import com.alibaba.fastjson.JSONObject;
import com.junliang.spring.util.IOHelper;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class voidTest {


    @Test
    public void jsonCan() {
        String json = "{  \"listOfCreditCardsForCustomerUsingCardNoAsInputInqRs\":{    \"listRs\":{      \"nextStartIndex\":\"0000\",      \"moreIndicator\":\"N\",      \"size\":3    },    \"creditCardInfo\":[      {        \"cardNo\":\"6250771000582957\",        \"accountOrgCode\":\"822\",        \"accountLogo\":\"110\",        \"accountNo\":\"0006250771000582957\",        \"customerNo\":\"0006250771000582957\",        \"cardSequenceNo\":1,        \"customerOrgCode\":\"822\",        \"relationshipOrgCode\":\"822\",        \"relationshipNo\":\"0006250771000582957\",        \"nfcEnrolled\":null,        \"nfcAssociatedCardNo\":null,        \"accountStatusCode\":null,        \"cardExpiryDate\":\"2022-03-31\",        \"cardStatusCode\":\"0\",        \"cardholderName\":null,        \"primaryCardNo\":\"0006250771000582957\",        \"primarySupplementaryIndicator\":\"P\",        \"cardholderRMCustomerNo\":\"410039477\",        \"cardToAddressSequenceNo\":1,        \"cardReplacementFee\":0.0E0,        \"highestBlockCode\":\"Y\",        \"cardActivationIndicator\":\"Y\",        \"accountBlockCode1\":null,        \"accountBlockCode2\":null,        \"blockCode\":\"Y\",        \"currencyCode\":\"156\"      },      {        \"cardNo\":\"5591390000458793\",        \"accountOrgCode\":\"823\",        \"accountLogo\":\"310\",        \"accountNo\":\"0005591390000458793\",        \"customerNo\":\"0006250771000582957\",        \"cardSequenceNo\":1,        \"customerOrgCode\":\"822\",        \"relationshipOrgCode\":\"822\",        \"relationshipNo\":\"0006250771000582957\",        \"nfcEnrolled\":null,        \"nfcAssociatedCardNo\":null,        \"accountStatusCode\":null,        \"cardExpiryDate\":\"2022-03-31\",        \"cardStatusCode\":\"0\",        \"cardholderName\":null,        \"primaryCardNo\":\"0006250771000582957\",        \"primarySupplementaryIndicator\":\"P\",        \"cardholderRMCustomerNo\":\"410039477\",        \"cardToAddressSequenceNo\":1,        \"cardReplacementFee\":0.0E0,        \"highestBlockCode\":\"Y\",        \"cardActivationIndicator\":\"N\",        \"accountBlockCode1\":null,        \"accountBlockCode2\":null,        \"blockCode\":null,        \"currencyCode\":\"840\"      },      {        \"cardNo\":\"5591390000458793\",        \"accountOrgCode\":\"823\",        \"accountLogo\":\"310\",        \"accountNo\":\"0005591390000458793\",        \"customerNo\":\"0006250771000582957\",        \"cardSequenceNo\":1,        \"customerOrgCode\":\"822\",        \"relationshipOrgCode\":\"822\",        \"relationshipNo\":\"0006250771000582957\",        \"nfcEnrolled\":null,        \"nfcAssociatedCardNo\":null,        \"accountStatusCode\":null,        \"cardExpiryDate\":\"2022-03-31\",        \"cardStatusCode\":\"0\",        \"cardholderName\":null,        \"primaryCardNo\":\"0006250771000582957\",        \"primarySupplementaryIndicator\":\"P\",        \"cardholderRMCustomerNo\":\"410039477\",        \"cardToAddressSequenceNo\":1,        \"cardReplacementFee\":0.0E0,        \"highestBlockCode\":\"Y\",        \"cardActivationIndicator\":\"N\",        \"accountBlockCode1\":null,        \"accountBlockCode2\":null,        \"blockCode\":null,        \"currencyCode\":\"840\"      }    ]  }}";
        System.out.println(json);

    }


    @Test
    public void getBingPicture() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = restTemplate.getForObject("http://cn.bing.com/HPImageArchive.aspx?format=js&n=1", JSONObject.class);

        String url = "http://cn.bing.com" + jsonObject.getJSONArray("images").getJSONObject(0).getString("url");
        //String usrHome = System.getProperty("user.home");
        String savePath = System.getProperty("user.home") + System.getProperty("file.separator") + "Pictures" + System.getProperty("file.separator") + "bing";
        //System.out.println(savePath);
        String filename = jsonObject.getJSONArray("images").getJSONObject(0).getString("copyright");
        filename = filename.substring(0, filename.indexOf("，")) + ".jpg";

        IOHelper.downLoadFromUrl(url, filename, savePath);
    }


}