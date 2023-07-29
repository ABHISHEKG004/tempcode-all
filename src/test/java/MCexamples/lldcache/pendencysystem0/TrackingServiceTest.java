package MCexamples.lldcache.pendencysystem0;

import MCexamples.pendencysystem0.models.CityTag;
import MCexamples.pendencysystem0.models.PaymentTag;
import MCexamples.pendencysystem0.models.StateTag;
import MCexamples.pendencysystem0.models.Tags;
import MCexamples.pendencysystem0.repositories.EntityRepo;
import MCexamples.pendencysystem0.repositories.EntityRepoInterface;
import MCexamples.pendencysystem0.repositories.TagRepo;
import MCexamples.pendencysystem0.repositories.TagRepoInterface;
import MCexamples.pendencysystem0.services.TrackingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TrackingServiceTest {

    private EntityRepoInterface entityRepoInterface;
    private TagRepoInterface tagRepoInterface;
    private TrackingService trackingService;

    Tags UPItag = new Tags(PaymentTag.UPI);
    Tags WalletTag = new Tags(PaymentTag.WALLET);

    Tags KarnatakaTag = new Tags(StateTag.Karnataka);
    Tags RajashthanTag = new Tags(StateTag.Rajasthan);

    Tags BangaloreTag = new Tags(CityTag.Bangalore);
    Tags MysoreTag = new Tags(CityTag.MYSORE);
    Tags jaipurTag = new Tags(CityTag.Jaipur);

    @BeforeEach
    void setUp() {

        entityRepoInterface = new EntityRepo();
        tagRepoInterface = new TagRepo();
        trackingService = new TrackingService(entityRepoInterface,tagRepoInterface);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFlow() {
        trackingService.startTracking("1112", Arrays.asList(UPItag,KarnatakaTag,BangaloreTag));
        trackingService.startTracking("2451", Arrays.asList(UPItag,KarnatakaTag,MysoreTag));
        trackingService.startTracking("3421", Arrays.asList(UPItag,RajashthanTag,jaipurTag));
        trackingService.startTracking("1221", Arrays.asList(WalletTag,KarnatakaTag,BangaloreTag));
//        trackingService.startTracking("1112", Arrays.asList(UPItag,KarnatakaTag,BangaloreTag));

//        System.out.println(Arrays.asList(UPItag));

        assert trackingService.getCounts(Arrays.asList(UPItag)) == 3;

        assert trackingService.getCounts(Arrays.asList(UPItag,KarnatakaTag)) == 2;

        assert trackingService.getCounts(Arrays.asList(UPItag,KarnatakaTag,BangaloreTag)) == 1;

        assert trackingService.getCounts(Arrays.asList(BangaloreTag)) == 0;

        trackingService.startTracking("4221", Arrays.asList(WalletTag,KarnatakaTag,BangaloreTag));
        trackingService.stopTracking("1112");
        trackingService.stopTracking("2451");
        trackingService.stopTracking("2451");

        assert trackingService.getCounts(Arrays.asList(UPItag)) == 1;
        assert trackingService.getCounts(Arrays.asList(WalletTag)) == 2;
        assert trackingService.getCounts(Arrays.asList(UPItag,KarnatakaTag,BangaloreTag)) == 0;

    }


}