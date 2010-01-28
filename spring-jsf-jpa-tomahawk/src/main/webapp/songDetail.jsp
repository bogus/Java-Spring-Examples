<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:c="http://java.sun.com/jsp/jstl/core">

<ui:composition>
	<h:form>
		<h:panelGrid columns="2">
			<h:outputLabel for="title" value="Title"></h:outputLabel>
			<h:outputLabel id="title" value="#{songDetail.song.title}"></h:outputLabel>

			<h:outputLabel for="artist" value="Artist"></h:outputLabel>
			<h:outputLabel id="artist" value="#{songDetail.song.artist}"></h:outputLabel>

			<h:outputLabel for="genre" value="Genre"></h:outputLabel>
			<h:outputLabel id="genre" value="#{songDetail.song.genre}"></h:outputLabel>
		</h:panelGrid>
		<h:commandButton value="Back" action="#{songDetail.back}"></h:commandButton>
	</h:form>
</ui:composition>
</html>