package br.com.ekom.dynamicjson.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibraryResponseDTO {

	private String bib_key;
	private String info_url;
	private String preview;
	private String preview_url;
	private DetailDTO details;

	public String getBib_key() {
		return bib_key;
	}

	public void setBib_key(String bib_key) {
		this.bib_key = bib_key;
	}

	public String getInfo_url() {
		return info_url;
	}

	public void setInfo_url(String info_url) {
		this.info_url = info_url;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getPreview_url() {
		return preview_url;
	}

	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}

	public DetailDTO getDetails() {
		return details;
	}

	public void setDetails(DetailDTO details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "OpenLibraryResponseDTO [bib_key=" + bib_key + ", info_url=" + info_url + ", preview=" + preview
				+ ", preview_url=" + preview_url + ", details=" + details + "]";
	}

}