/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	config.filebrowserBrowseUrl ='../four/ckfinder/ckfinder.html';
	config.filebrowserImageBrowseUrl ='../four/ckfinder/ckfinder.html?Type=Images';
	config.filebrowserFlashBrowseUrl ='../four/ckfinder/ckfinder.html?Type=Flash'; 
	config.filebrowserUploadUrl ='../four/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	config.filebrowserImageUploadUrl ='../four/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	config.filebrowserFlashUploadUrl ='../four/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
};
