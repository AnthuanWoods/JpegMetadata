/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metadata;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.common.ImageMetadata.ImageMetadataItem;
import org.apache.commons.imaging.common.RationalNumber;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.ExifTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.GpsTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;

/**
 *
 * @author Owner
 */
public class Metadata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ImageReadException, IOException {

        File f = new File("C:/Users/Owner/Pictures/trial.jpg");
        ImageMetadata metadata = Imaging.getMetadata(f);
        JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
        System.out.println(f);

        // print out numerous EXIF tags
        printTagValue(jpegMetadata, TiffTagConstants.TIFF_TAG_XRESOLUTION);
        printTagValue(jpegMetadata, TiffTagConstants.TIFF_TAG_DATE_TIME);
        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL);
        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_DATE_TIME_DIGITIZED);
        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_ISO);
        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_SHUTTER_SPEED_VALUE);
        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_APERTURE_VALUE);
        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_BRIGHTNESS_VALUE);
        printTagValue(jpegMetadata, GpsTagConstants.GPS_TAG_GPS_LATITUDE_REF);
        printTagValue(jpegMetadata, GpsTagConstants.GPS_TAG_GPS_LATITUDE);
        printTagValue(jpegMetadata, GpsTagConstants.GPS_TAG_GPS_LONGITUDE_REF);
        printTagValue(jpegMetadata, GpsTagConstants.GPS_TAG_GPS_LONGITUDE);
    }

    private static void printTagValue(JpegImageMetadata jpegMetadata, TagInfo tagInfo) {
        TiffField field = jpegMetadata.findEXIFValueWithExactMatch(tagInfo);
        if (field == null) {
            System.out.println(tagInfo.name + ": " + "Not Found.");
        } else {
            System.out.println(tagInfo.name + ": " + field.getValueDescription());
        }
    }
}
